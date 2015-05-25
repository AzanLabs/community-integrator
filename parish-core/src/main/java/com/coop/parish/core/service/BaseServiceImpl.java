package com.coop.parish.core.service;

import javax.persistence.EntityManager;

public abstract class BaseServiceImpl {
	
	protected EntityManager em = null;
	
	public BaseServiceImpl(EntityManager em){
		this.em = em;
	}
	
	public EntityManager getEm() {
		return em;
	}

}
