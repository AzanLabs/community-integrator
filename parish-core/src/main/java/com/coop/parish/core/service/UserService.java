package com.coop.parish.core.service;

import com.coop.parish.core.beans.UserBean;

public interface UserService extends BaseService{
	
	public UserBean getUserById(Integer id) throws Exception;
	
	public void updateChurchId(UserBean user) throws Exception;
}
