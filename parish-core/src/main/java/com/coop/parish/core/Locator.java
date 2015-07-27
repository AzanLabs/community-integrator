package com.coop.parish.core;

import javax.persistence.EntityManager;

import com.coop.parish.core.service.BibleVerseService;
import com.coop.parish.core.service.ChurchService;
import com.coop.parish.core.service.EventService;
import com.coop.parish.core.service.LoginService;
import com.coop.parish.core.service.PriestService;
import com.coop.parish.core.service.UserService;

public interface Locator {
	
	public LoginService getLoginService();
	
	public LoginService getLoginService(EntityManager em);
	
	public ChurchService getChurchService();
	
	public ChurchService getChurchService(EntityManager em);
	
	public PriestService getPriestService();
	
	public PriestService getPriestService(EntityManager em);
	
	public EventService getEventService();
	
	public EventService getEventService(EntityManager em);
	
	public UserService getUserService();
	
	public UserService getUserService(EntityManager em);
	
	public BibleVerseService getBibleVerseService();
	
	public BibleVerseService getBibleVerseService(EntityManager em);
}
