package com.coop.parish.core.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.coop.parish.core.beans.EventBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.constants.Constants;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.data.modal.Audit;
import com.coop.parish.data.modal.Church;
import com.coop.parish.data.modal.Events;

public class EventServiceImpl extends BaseServiceImpl implements EventService {

	public EventServiceImpl(EntityManager em) {
		super(em);
	}

	public EventBean getEventById(int id) throws Exception {
		Events events = null;
		if(id <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		String str = "Select e from Event as e where e.id=:id and e.isActive=:isActive";
		Query query = em.createQuery(str);
		query.setParameter("id", id);
		query.setParameter("isActive", true);
		try{
			events =  (Events)query.getSingleResult();
		}catch(NoResultException e){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return new EventBean(events);
	}

	public EventBean updateEvent(EventBean eventBean, UserBean user) throws Exception {
		Events events = null;
		int id = 0;
		if(eventBean == null){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		id = eventBean.getId();
		if(id <= 0){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		Events fromDB = em.find(Events.class, id);
		if(fromDB != null){
			events = eventBean.toBO();
			
			Audit audit = new Audit();
			audit.setCreatedOn(fromDB.getAudit().getCreatedOn());
			audit.setCreatedBy(fromDB.getAudit().getCreatedBy());
			audit.setLastModifiedBy(user.getId());
			audit.setLastModifiedOn(new Date());
			
			events.setChurch(new Church(user.getChurchId()));
			events.setActive(true);
			events.setAudit(audit);
			em.merge(events);
		}
		return new EventBean(events);
	}
	
	public int deleteEvent(Integer id) throws Exception{
		Events events = null;
		if(id == null || id <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		events = em.find(Events.class, id);
		if(events == null){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		events.setActive(false);
		em.merge(events);
		return events.getId();
	}
	
	private boolean isInDB(int id) throws ParishException{
		Query q = em.createQuery("select id from Event e where e.id=:id");
		q.setParameter("id", id);
		try{
			q.getSingleResult();
		}catch(NoResultException e){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return true;
	}
	
	public List<EventBean> getAllEventsOfChurch(Integer churchId) throws ParishException{
		if(churchId <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		List<EventBean> eventBeans = new ArrayList<EventBean>();
		List<Events> events = null;
		Query query = em.createQuery("select e from Event e where e.church.id = :churchId and e.isActive = :isActive");
		query.setParameter("churchId",churchId);
		query.setParameter("isActive", true);
		events = query.getResultList();
		if(events != null){
			for(Events event : events){
				eventBeans.add(new EventBean(event));
			}
		}
		return eventBeans;
	}

	public EventBean saveEvents(EventBean eventBean, UserBean user)
			throws ParishException {
		Events events = null;
		if(eventBean == null || user == null){
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		if(user.getChurchId() == null){
			throw new ParishException("Forbidden");
		}
		events  = eventBean.toBO();
		events.setActive(true);
		events.setChurch(new Church(user.getChurchId()));
		
		Audit audit = new Audit();
		audit.setCreatedBy(user.getId());
		audit.setLastModifiedBy(user.getId());
		audit.setCreatedOn(new Date());
		audit.setLastModifiedOn(new Date());
		events.setAudit(audit);
		em.persist(events);
		return new EventBean(events);	
	}

}
