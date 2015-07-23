package com.coop.parish.core.service;

import java.nio.charset.Charset;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.coop.parish.core.beans.ChurchBean;
import com.coop.parish.core.beans.EChurchBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.constants.Constants;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.data.modal.Audit;
import com.coop.parish.data.modal.Church;
import com.coop.parish.data.modal.ChurchAdditionalInfo;

public class ChurchServiceImpl extends BaseServiceImpl implements ChurchService{

	public ChurchServiceImpl(EntityManager em) {
		super(em);
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
		try{
			church =  (Church)query.getSingleResult();
		}catch(NoResultException e){
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return new ChurchBean(church);
	}

	public ChurchBean updateChurch(ChurchBean churchBean, UserBean user) throws Exception {
		Church church = null;
		int id = 0;
		if(churchBean == null){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		id = churchBean.getId();
		if(id <= 0){
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		Church fromDB = em.find(Church.class, id);
		System.out.println("audit"+fromDB.getAudit().getCreatedOn());
		if(fromDB != null){
			church = churchBean.toBO();
	
			Audit audit = new Audit();
			audit.setCreatedOn(fromDB.getAudit().getCreatedOn());
			audit.setCreatedBy(fromDB.getAudit().getCreatedBy());
			audit.setLastModifiedBy(user.getId());
			audit.setLastModifiedOn(new Date());
			
			church.setActive(true);
			church.setAudit(audit);
			
			fromDB.getAdditionalInfo().setInfo(church.getAdditionalInfo().getInfo());
			church.setAdditionalInfo(fromDB.getAdditionalInfo());
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

	public EChurchBean getEntireChurch(int id) throws Exception {
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
		return new EChurchBean(church);
	}
	
	/**
	 * This Method Creates a new Church Instance, and modifies the status
	 * @param churchBean - bean which contains all the church information.
	 * @param user - bean which has the current user information
	 * @return - the saved church bean
	 * @throws Exception  If improper data is send to persist.
	 */
	public ChurchBean saveChurchFirstSteps(ChurchBean churchBean, UserBean user)
			throws ParishException {
		if(churchBean == null || user == null) {//checks the input params
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		if(user.getChurchId() == null){
			throw new ParishException("Forbidden Request"); //TODO : change it to run time exception
		}
		//convert bean to business object
		Church church = churchBean.toBO();
		
		//touch and complete BO
		church.setId(user.getChurchId());
		church.setActive(true);
		ChurchAdditionalInfo addInfo = new ChurchAdditionalInfo();
		addInfo.setInfo(churchBean.getAdditionalInfo().getBytes(Charset.forName("UTF-8")));
		church.setAdditionalInfo(addInfo);
		
		Audit audit = new Audit();
		audit.setCreatedOn(new Date());
		audit.setCreatedBy(user.getId());
		audit.setLastModifiedOn(new Date());
		audit.setLastModifiedBy(user.getId());
		
		church.setAudit(audit);
		em.persist(church); //persist 

		return new ChurchBean(church);
	}
	
	/**
	 * This method checks if the church profile is completed or not
	 * @param churchId 
	 * @return boolean status TRUE / FALSE
	 */
	public boolean isChurchSet(Integer churchId) {
		boolean isSet = false;
		if(churchId == null) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		Query query = em.createQuery("select id from Church c where c.id = :id and c.isActive = :isActive");
		query.setParameter("id", churchId);
		query.setParameter("isActive", true);
		try {
			query.getSingleResult();
		} catch(NoResultException e) {
			return isSet;
		}
		isSet = true;
		return isSet;
	}
}
