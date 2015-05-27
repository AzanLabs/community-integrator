package com.coop.parish.core;

import com.coop.parish.core.service.LoginService;
import com.coop.parish.core.service.LoginServiceImpl;
import com.coop.parish.data.TransactionManager;

/**
 * 
 */
public class ServiceLocator implements Locator{
	
	private static Locator serviceLocator = null;
	private TransactionManager tm = new TransactionManager();
	
	public static Locator instance() {
		if(serviceLocator == null){
			serviceLocator = new ServiceLocator();
		}
		return serviceLocator;
	}

	public LoginService getLoginService(){
		LoginService service = new LoginServiceImpl(tm.getEntityManager());
		System.out.println("em" +service.getEm());
		service = (LoginService) ServiceProxy.newInstance(service);
		return service;
	}
	
}
