package com.coop.parish.core.service;

import com.coop.parish.data.modal.Email;
import com.coop.parish.data.modal.User;

public interface EmailService extends BaseService{
	
	public static enum EmailType {
		PASSWORDRESET
	}

	public Email sendAndSaveEmail(User user, String emailId, EmailType e);
}
