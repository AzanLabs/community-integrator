package com.coop.parish.core.service;

import com.coop.parish.data.modal.User;

public interface LoginService extends BaseService{
	
	public User getUser(User user);
}
