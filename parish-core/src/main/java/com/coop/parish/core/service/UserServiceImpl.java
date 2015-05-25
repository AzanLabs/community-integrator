package com.coop.parish.core.service;

import javax.persistence.EntityManager;

import com.coop.parish.data.modal.User;

public class UserServiceImpl extends BaseServiceImpl implements UserService{
	
	public UserServiceImpl(EntityManager em){
		super(em);
	}
	public void saveUser() {
		User usr = new User();
		usr.setName("sankar");
		usr.setPwd("pwd");
		em.persist(usr);
		System.out.println("the id of resulting ust"+usr.getId());
	}
	
	private void anotherMthd(){
		System.out.println("inside another mthd");
	}
}
