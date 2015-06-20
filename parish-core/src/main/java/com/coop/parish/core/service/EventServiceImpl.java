package com.coop.parish.core.service;


import java.text.SimpleDateFormat;
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
import com.coop.parish.data.modal.Event;

public class EventServiceImpl extends BaseServiceImpl implements EventService{

	public EventServiceImpl(EntityManager em) {
		super(em);
	}

	public EventBean getEventById(int id) throws Exception {
		Event event = null;
		if(id <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		String str = "Select e from Event as e where e.id=:id and e.isActive=:isActive";
		Query query = em.createQuery(str);
		query.setParameter("id", id);
		query.setParameter("isActive", true);
		try{
			event =  (Event)query.getSingleResult();
		}catch(NoResultException e){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return new EventBean(event);
	}

	public EventBean updateEvent(EventBean eventBean) throws Exception {
		Event event = null;
		int id = 0;
		if(eventBean == null){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		id = eventBean.getId();
		if(id <= 0){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		if(isInDB(id)){
			event = eventBean.toBO();
			event.setActive(true);
			em.merge(event);
		}
		return new EventBean(event);
	}
	
	public int deleteEvent(Integer id) throws Exception{
		Event event = null;
		if(id == null || id <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		event = em.find(Event.class, id);
		if(event == null){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		event.setActive(false);
		em.merge(event);
		return event.getId();
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

	public EventBean saveEvent(EventBean eventBean, UserBean user) throws Exception {
		Event event = null;
		if(eventBean == null || user == null){
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		event  = eventBean.toBO();
		event.setActive(true);
		event.setChurchId(user.getChurchId());
		
		Audit audit = new Audit();
		audit.setCreatedBy(user.getId());
		audit.setLastModifiedBy(user.getId());
		audit.setCreatedOn(new Date());
		audit.setLastModifiedOn(new Date());
		event.setAudit(audit);
		em.persist(event);
		return new EventBean(event);	
	}
	
	public List<EventBean> getAllEventsOfChurch(Integer churchId) throws ParishException{
		if(churchId <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		List<EventBean> eventBeans = new ArrayList<EventBean>();
		List<Event> events = null;
		Query query = em.createQuery("select e from Event e where e.churchId = :churchId and e.isActive = :isActive");
		query.setParameter("churchId",churchId);
		query.setParameter("isActive", true);
		events = query.getResultList();
		if(events != null){
			for(Event event : events){
				eventBeans.add(new EventBean(event));
			}
		}
		return eventBeans;
	}
}
