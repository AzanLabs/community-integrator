package com.coop.parish.core.service;

import com.coop.parish.core.exceptions.ParishException;

public interface UserService extends BaseService{
	
	/**
	 * This Method Changes the church_is_set status of User
	 * @param userId 
	 * @param status boolean status which holds if the church is set or not
	 * @throws ParishException  is thrown if the user is not present 
	 */
}
