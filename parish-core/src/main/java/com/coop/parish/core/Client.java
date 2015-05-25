package com.coop.parish.core;

import com.coop.parish.core.service.UserService;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService service = ServiceLocator.instance().getUserService();
		service.saveUser();
	}
}
