package com.coop.parish.core.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.constants.Constants;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.data.modal.User;

public class LoginServiceImpl extends BaseServiceImpl implements LoginService{
	
	public LoginServiceImpl(EntityManager em){
		super(em);
	}

	public UserBean isUserPresent(String identifier) throws ParishException {
		User user = null;
		String queryStmt = "select usr from User usr where usr.identifier = :identifier and usr.isActive = :isActive";
		Query query = em.createQuery(queryStmt);
		query.setParameter("identifier", identifier);
		query.setParameter("isActive", true);
		try{
			user = (User)query.getSingleResult();
		}catch(NoResultException e){
			throw new ParishException(Constants.AUTHENTICATION_FAILED);
		}
		return new UserBean(user);
	}
	
	
}
