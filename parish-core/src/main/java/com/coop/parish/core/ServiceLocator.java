package com.coop.parish.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.coop.parish.core.service.ChurchService;
import com.coop.parish.core.service.ChurchServiceImpl;
import com.coop.parish.core.service.EventService;
import com.coop.parish.core.service.EventServiceImpl;
import com.coop.parish.core.service.LoginService;
import com.coop.parish.core.service.LoginServiceImpl;
import com.coop.parish.core.service.PriestService;
import com.coop.parish.core.service.PriestServiceImpl;
import com.coop.parish.core.service.UserService;
import com.coop.parish.core.service.UserServiceImpl;
import com.coop.parish.data.TransactionManager;

/**
 * service locator is bases on Assembler pattern which holds the object creation 
 * and manages dependency injection.
 */
public class ServiceLocator implements Locator{
	//single service locator for the whole application 
	private static Locator serviceLocator = null;
	private static EntityManagerFactory emf= null;
	
	//lazy loading the service locator
	public static Locator instance() {
		if(serviceLocator == null){
			serviceLocator = new ServiceLocator();
		}
		if(emf == null){
			emf = TransactionManager.getEMF();
		}
		return serviceLocator;
	}
	

	public LoginService getLoginService(){
		EntityManager em = emf.createEntityManager();
		LoginService service = new LoginServiceImpl(em);
		System.out.println("em" +service.getEm());
		service = (LoginService) ServiceProxy.newInstance(service);
		return service;
	}
	
	public LoginService getLoginService(EntityManager em){
		return new LoginServiceImpl(em);
	}

	public ChurchService getChurchService() {
		EntityManager em = emf.createEntityManager();
		ChurchService service = new ChurchServiceImpl(em);
		service = (ChurchService)ServiceProxy.newInstance(service);
		return service;
	}
	
	public ChurchService getChurchService(EntityManager em) {
		return new ChurchServiceImpl(em);
	}

	public PriestService getPriestService() {
		EntityManager em = emf.createEntityManager();
		PriestService service = new PriestServiceImpl(em);
		service = (PriestService)ServiceProxy.newInstance(service);
		return service;
	}

	public PriestService getPriestService(EntityManager em) {
		return new PriestServiceImpl(em);
	}

	public EventService getEventService() {
		EntityManager em = emf.createEntityManager();
		EventService service = new EventServiceImpl(em);
		service = (EventService)ServiceProxy.newInstance(service);
		return service;
	}

	public EventService getEventService(EntityManager em) {
		return new EventServiceImpl(em);
	}

	public UserService getUserService() {
		EntityManager em = emf.createEntityManager();
		UserService service = new UserServiceImpl(em);
		service = (UserService)ServiceProxy.newInstance(service);
		return service;
	}

	public UserService getUserService(EntityManager em) {
		return new UserServiceImpl(em);
	}
	
	
}
