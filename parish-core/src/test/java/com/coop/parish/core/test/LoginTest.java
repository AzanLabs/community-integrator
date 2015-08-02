package com.coop.parish.core.test;

import org.testng.annotations.Test;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.LoginService;

public class LoginTest{
	
	LoginService service = ServiceLocator.instance().getLoginService();
	
	@Test(enabled=false)
	public void testLogin() throws ParishException {
		UserBean user = service.validateLogin("admin", "admin");
		System.out.println(user.getIdentifier());
	}
	
	@Test(enabled=true)
	public void testResetPwd() throws ParishException{
		Integer emailIdentifier = service.resetPassword("admin");
		System.out.println(emailIdentifier);
	}
		
}
