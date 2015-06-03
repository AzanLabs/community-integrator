package com.coop.parish.core.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.coop.parish.core.beans.ChurchBean;
import com.coop.parish.core.constants.Constants;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.data.modal.Church;

public class ChurchServiceImpl extends BaseServiceImpl implements ChurchService{

	public ChurchServiceImpl(EntityManager em) {
		super(em);
	}

	public ChurchBean saveChurch(ChurchBean churchBean) throws Exception {
		Church church = null;
		if(churchBean == null){
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		church  = churchBean.toBO();
		church.setActive(true);
		em.persist(church);
		return new ChurchBean(church);		
	}

	public ChurchBean getChurchById(int id) throws Exception {
		Church church = null;
		if(id <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		String str = "Select c from Church as c where c.id=:id and c.isActive=:isActive";
		Query query = em.createQuery(str);
		query.setParameter("id", id);
		query.setParameter("isActive", true);
		Object obj =  query.getSingleResult();
		if(obj == null){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		church = (Church)obj;
		return new ChurchBean(church);
	}

	public ChurchBean updateChurch(ChurchBean churchBean) throws Exception {
		Church church = null;
		int id = 0;
		if(churchBean == null){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		id = churchBean.getId();
		if(id <= 0){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		if(isInDB(id)){
			church = churchBean.toBO();
			church.setActive(true);
			em.merge(church);
		}
		return new ChurchBean(church);
	}
	
	public int deleteChurch(int id) throws Exception{
		Church church = null;
		if(id <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		church = em.find(Church.class, id);
		if(church == null){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		church.setActive(false);
		em.merge(church);
		return church.getId();
	}
	
	private boolean isInDB(int id) throws ParishException{
		Query q = em.createQuery("select id from Church c where c.id=:id");
		q.setParameter("id", id);
		try{
			q.getSingleResult();
		}catch(NoResultException e){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return true;
	
	}
}
