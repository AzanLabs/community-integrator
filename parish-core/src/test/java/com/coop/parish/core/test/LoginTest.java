package com.coop.parish.core.test;

import org.testng.annotations.Test;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.LoginService;
import com.coop.parish.core.service.UserService;
import com.coop.parish.data.modal.User;

public class LoginTest{
	
	LoginService service = ServiceLocator.instance().getLoginService();
	
	@Test
	public void testLogin() throws ParishException {
		UserBean user = service.validateLogin("admin", "admin");
		System.out.println(user.getIdentifier());
	}
		
}
