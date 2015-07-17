package com.coop.parish.core.test;

import org.testng.annotations.Test;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.LoginService;

public class LoginTest{
	
	LoginService service = ServiceLocator.instance().getLoginService();
	
	
	@Test(expectedExceptions = ParishException.class)
	public void myTest() throws ParishException{
		UserBean userBean = null;
		userBean = service.validateLogin("select", "'''");
	}
		
}
