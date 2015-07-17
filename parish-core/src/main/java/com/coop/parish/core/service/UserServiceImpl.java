package com.coop.parish.core.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.coop.parish.core.constants.Constants;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.data.modal.Audit;
import com.coop.parish.data.modal.User;

public class UserServiceImpl extends BaseServiceImpl implements UserService{

	public UserServiceImpl(EntityManager em) {
		super(em);
	}

	/**
	 * This Method Changes the church_is_set status of User
	 * @param userId 
	 * @param status boolean status which holds if the church is set or not
	 * @throws ParishException  is thrown if the user is not present 
	 */
	public void updateChurchStatus(Integer userId, Boolean status)
			throws ParishException {
		if(userId == null || status == null) {//check the validity of params
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		User user = null;
		//get the Entity
		Query query = em.createQuery("select usr from User usr where usr.id = :userId and usr.isActive = :isActive");
		query.setParameter("userId", userId);
		query.setParameter("isActive", true);
		try {
			user = (User)query.getSingleResult();
		}catch(NoResultException e) { 
			throw new ParishException("Unexcepted Error"); 
		}
		//dirty checking to avoid update call
		if(user.isChurchIsSet() == status){
			return;
		}
		Audit audit = user.getAudit();
		audit.setLastModifiedBy(userId);
		audit.setLastModifiedOn(new Date());
		user.setAudit(audit);
		user.setActive(true);
		user.setChurchIsSet(status);
		em.merge(user);
	}
}
