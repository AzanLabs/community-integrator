package com.coop.parish.core;

import javax.persistence.EntityManager;

import com.coop.parish.core.service.ChurchService;
import com.coop.parish.core.service.LoginService;

public interface Locator {
	
	public LoginService getLoginService();
	
	public LoginService getLoginService(EntityManager em);
	
	public ChurchService getChurchService();
	
	public ChurchService getChurchService(EntityManager em);
}
