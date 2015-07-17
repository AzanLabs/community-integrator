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
	
	/**
	 * This Method authenticate and authorizes the user, throws Parish Exception if fails
	 * @param identifier  Unique identifier of the user, may be email, user name etc, not null
	 * @param password  Password to login to the system, not null
	 * @return UserBean  The User which corresponds to the identifier
	 * @throws ParishException  If the corresponding user is not Present or the Password does not match
	 */
	public UserBean validateLogin(String identifier, String password)
			throws ParishException {
		User user = null;
		if(identifier == null || password == null || identifier.isEmpty() || password.isEmpty()) {
			throw new ParishException(Constants.PARAM_NULL_MSG);
		}
		
		user = this.authenticate(identifier); //authentication
		this.authorize(identifier, password, user); //authorize
		return new UserBean(user);
	}
	
	/**
	 * This Methods checks if the user with the given identifier exists, throws parish Exception if not.
	 * @param identifier unique user identifier
	 * @return User Entity
	 * @throws ParishException if the user !exists.
	 */
	private User authenticate(String identifier) 
			throws ParishException {
		User user = null;
		Query query = em.createQuery("Select usr from User as usr where usr.identifier = :identifier and usr.isActive = :isActive");
		//TODO : Consider SQL Injection
		query.setParameter("identifier", identifier);
		query.setParameter("isActive", true);
		try {
			user = (User) query.getSingleResult();
		} catch(NoResultException e){
			throw new ParishException(Constants.AUTHENTICATION_FAILED);
		}
		return user;
	}
	
	/**
	 * This Method Checks if the password matches, throws ParishException if not.
	 * @param identifier
	 * @param password
	 * @param user User Data from Database
	 * @throws ParishException if Password does not Matches
	 */
	private void authorize(String identifier, String password, User user) 
			throws ParishException {
		//TODO : Consider attacking techniques
		if(!user.getPassword().equals(password)) {
			throw new ParishException(Constants.AUTHORIZATION_FAILED);
		}
	}
	
}
