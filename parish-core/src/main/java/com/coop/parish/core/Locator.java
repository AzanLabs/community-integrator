package com.coop.parish.core;

import javax.persistence.EntityManager;

import com.coop.parish.core.service.ChurchService;
import com.coop.parish.core.service.EventService;
import com.coop.parish.core.service.LoginService;
import com.coop.parish.core.service.PriestService;

public interface Locator {
	
	public LoginService getLoginService();
	
	public LoginService getLoginService(EntityManager em);
	
	public ChurchService getChurchService();
	
	public ChurchService getChurchService(EntityManager em);
	
	public PriestService getPriestService();
	
	public PriestService getPriestService(EntityManager em);
	
	public EventService getEventService();
	
	public EventService getEventService(EntityManager em);
}
