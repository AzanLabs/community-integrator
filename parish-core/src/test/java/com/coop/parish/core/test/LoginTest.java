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
	
	
	@Test(expectedExceptions = ParishException.class)
	public void myTest() throws ParishException{
		UserBean userBean = null;
		//userBean = service.validateLogin("select", "'''");
		UserService service = ServiceLocator.instance().getUserService();
		try{
			System.out.println(true == false);
			service.updateChurchStatus(1, true);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("msg"+e.getMessage());
		}
		
	}
		
}
