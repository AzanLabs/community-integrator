package com.coop.parish.core.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.coop.parish.core.beans.PriestBean;
import com.coop.parish.core.constants.Constants;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.data.modal.Church;
import com.coop.parish.data.modal.Priest;

public class PriestServiceImpl extends BaseServiceImpl implements PriestService{

	public PriestServiceImpl(EntityManager em) {
		super(em);
	}

	public PriestBean savePriest(PriestBean priestBean) throws Exception {
		Priest priest = null;
		if(priestBean == null){
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		priest  = priestBean.toBO();
		priest.setActive(true);
		em.persist(priest);
		return new PriestBean(priest);	
	}

	public PriestBean getPriestById(int id) throws Exception {
		Priest priest = null;
		if(id <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		String str = "Select p from Priest as p where p.id=:id and p.isActive=:isActive";
		Query query = em.createQuery(str);
		query.setParameter("id", id);
		query.setParameter("isActive", true);
		try{
			priest =  (Priest)query.getSingleResult();
		}catch(NoResultException e){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return new PriestBean(priest);
	}

	public PriestBean updatePriest(PriestBean priestBean) throws Exception {
		Priest priest = null;
		int id = 0;
		if(priestBean == null){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		id = priestBean.getId();
		if(id <= 0){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		if(isInDB(id)){
			priest = priestBean.toBO();
			priest.setActive(true);
			em.merge(priest);
		}
		return new PriestBean(priest);
	}

	public int deletePriest(int id) throws Exception {
		Priest priest = null;
		if(id <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		priest = em.find(Priest.class, id);
		if(priest == null){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		priest.setActive(false);
		em.merge(priest);
		return priest.getId();
	}
	
	private boolean isInDB(int id) throws ParishException{
		Query q = em.createQuery("select id from Priest p where p.id=:id");
		q.setParameter("id", id);
		try{
			q.getSingleResult();
		}catch(NoResultException e){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return true;
	
	}

	public List<PriestBean> getAllPriest(int churchId) throws ParishException {
		List<Priest> priests = null;
		List<PriestBean> priestBeans = new ArrayList<PriestBean>();
		if(churchId <= 0){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		Query q = em.createQuery("select p from priest p where churchId = :churchId and isActive = :isActive");
		q.setParameter("churchId", churchId);
		q.setParameter("isActive", true);
		priests = q.getResultList();
		//convert to priest bean
		if(priests != null){
			for(Priest p : priests){
				priestBeans.add(new PriestBean(p));
			}
		}
		return priestBeans;
	}

}
