package com.coop.parish.core;

import com.coop.parish.core.service.LoginService;
import com.coop.parish.data.modal.User;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginService service = ServiceLocator.instance().getLoginService();
		User user = new User();
		user.setIdentifier("admin");
		user.setPassword("");
		user = service.getUser(user);
		System.out.println("output "+user);
	}
}
