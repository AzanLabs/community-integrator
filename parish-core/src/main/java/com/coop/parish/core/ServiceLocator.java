package com.coop.parish.core;

import com.coop.parish.core.service.UserService;
import com.coop.parish.core.service.UserServiceImpl;
import com.coop.parish.data.TransactionManager;

public class ServiceLocator implements Locator{
	
	private static Locator serviceLocator = null;
	private TransactionManager tm = new TransactionManager();
	
	public static Locator instance() {
		if(serviceLocator == null){
			serviceLocator = new ServiceLocator();
		}
		return serviceLocator;
	}

	public UserService getUserService(){
		UserService service = new UserServiceImpl(tm.getEntityManager());
		System.out.println("em" +service.getEm());
		service = (UserService) ServiceProxy.newInstance(service);
		return service;
	}
	
	

}
