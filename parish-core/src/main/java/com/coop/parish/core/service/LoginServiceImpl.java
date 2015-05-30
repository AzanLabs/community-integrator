package com.coop.parish.core.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.coop.parish.data.modal.User;

public class LoginServiceImpl extends BaseServiceImpl implements LoginService{
	
	public LoginServiceImpl(EntityManager em){
		super(em);
	}

	public User getUser(User user) {
		
		User returnObj = null;
		String queryStmt = "select usr from User usr where usr.identifier = :identifier and usr.password = :password";
		Query query = em.createQuery(queryStmt);
		em.getTransaction();
		query.setParameter("identifier", user.getIdentifier());
		query.setParameter("password", user.getPassword());
		try{
		returnObj = (User) query.getSingleResult();
		}catch(NoResultException e){
			e.printStackTrace();
		}
		return returnObj;
	}
	
	
}
