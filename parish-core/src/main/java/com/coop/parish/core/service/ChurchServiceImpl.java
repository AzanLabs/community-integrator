package com.coop.parish.core.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.coop.parish.core.beans.ChurchBean;
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

	public ChurchBean updateChurch(ChurchBean churchBean, UserBean user) throws ParishException {
		this.updateChurchDetails(churchBean, user);
		this.updateChurchAddInfo(churchBean, user);
		return churchBean;
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
		church.setId(user.getChurchId()); //id for church is predefined
		church.setActive(true);
		ChurchAdditionalInfo addInfo = new ChurchAdditionalInfo();
		addInfo.setInfo(churchBean.getAdditionalInfo());
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
	

	/**
	 * Update the church Details excluding church additional info
	 * @param churchBean 
	 * @param user current session user
	 * @return Updated values
	 * @throws ParishException if the Entity doesn't exists
	 */
	public ChurchBean updateChurchDetails(ChurchBean churchBean, UserBean user)
			throws ParishException {
		//check for null params
		if(churchBean == null || user == null || churchBean.getId() == null) {
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		
		if(churchBean.getId() <= 0 || user.getChurchId() == null) {
			throw new ParishException("Forbidden Request");
		}
		
		//TODO : direct queries are Typo Error Prone and difficult to maintain, But fast and decrease the number of queries executed 
		StringBuilder builder = new StringBuilder("update Church c set c.name = :name, c.doorNo = :doorNo, c.street = :street, c.village = :village, c.taluk = :taluk, c.district  = :district, ");
		builder.append("c.state = :state, c.country = :country, c.pincode = :pincode, ");
		builder.append("c.telephoneNo = :telephoneNo, c.mobileNo = :mobileNo, c.emailId = :emailId, c.diocese = :diocese, ");
		builder.append("c.audit.lastModifiedBy = :lastModifiedBy, c.audit.lastModifiedOn = :lastModifiedOn ");
		builder.append("where c.id = :id and c.isActive = :isActive");
		
		Query q = em.createQuery(builder.toString());
		q.setParameter("name", churchBean.getName());	
		
		q.setParameter("doorNo", churchBean.getDoorNo());
		q.setParameter("street", churchBean.getStreet());
		q.setParameter("village", churchBean.getVillage());
		q.setParameter("taluk", churchBean.getTaluk());
		q.setParameter("district", churchBean.getDistrict());
		q.setParameter("state", churchBean.getState());
		q.setParameter("country", churchBean.getCountry());
		q.setParameter("pincode", churchBean.getPincode());
		
		q.setParameter("telephoneNo", churchBean.getTelephoneNo());
		q.setParameter("mobileNo", churchBean.getMobileNo());
		q.setParameter("emailId", churchBean.getEmailId());
		q.setParameter("diocese", churchBean.getDiocese());
		
		q.setParameter("lastModifiedOn", new Date());
		q.setParameter("lastModifiedBy", user.getId());
		
		q.setParameter("id", churchBean.getId());
		q.setParameter("isActive", true);
		
		int res = q.executeUpdate();
		if(res <= 0) {
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return churchBean;
	}
	
	/**
	 * update the church additional info
	 * @param churchBean
	 * @param user current session user info
	 * @return Updated value
	 * @throws ParishException if the entity to update doesn't exists
	 */
	public ChurchBean updateChurchAddInfo(ChurchBean churchBean, UserBean user)
			throws ParishException {
		//check for null params
		if(churchBean == null || user == null || churchBean.getId() == null) {
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		if(churchBean.getId() <= 0 || user.getChurchId() == null || !this.isChurchSet(churchBean.getId())) {
			throw new ParishException("Forbidden Request");
		}
	
		StringBuilder builder = new StringBuilder("update ChurchAdditionalInfo ci set ci.info = :info where ci.churchId = :churchId");
		Query query = em.createQuery(builder.toString());
		query.setParameter("info", churchBean.getAdditionalInfo());
		query.setParameter("churchId", churchBean.getId());
		
		int res = query.executeUpdate();
		if(res <= 0) {
			throw new ParishException(Constants.NO_SUCH_OBJECT);
		}
		return churchBean;
	}
}
