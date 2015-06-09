package com.coop.parish.core.service;

import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;

public interface LoginService extends BaseService{
	
	public UserBean isUserPresent(String identifier) throws ParishException;
}
