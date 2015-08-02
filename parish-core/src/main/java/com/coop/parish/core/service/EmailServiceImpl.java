package com.coop.parish.core.service;

import java.util.Date;

import javax.persistence.EntityManager;

import com.coop.parish.core.constants.Constants;
import com.coop.parish.data.modal.Email;
import com.coop.parish.data.modal.User;

public class EmailServiceImpl extends BaseServiceImpl implements EmailService{

	public EmailServiceImpl(EntityManager em) {
		super(em);
	}

	public Email sendAndSaveEmail(User user, String emailId, EmailType e) {
		
		if(user == null || emailId == null) {
			throw new NullPointerException(Constants.PARAM_NULL_MSG);
		}
		String msg = null;
		
		Email email = new Email();
		email.setSendTo(emailId);
		email.setSubject("Parish - Password Reset Request");
		if(e.equals(EmailType.PASSWORDRESET)) {
			msg = "Dear User, Ur password has been reset"+user.getPassword();  //should be changed pwd
		}
		email.setMessage(msg); 
		email.setStatus("SEND");
		email.setActive(true);
		email.setUserId(user.getId());
		email.setCreatedOn(new Date());
		
		em.persist(email);
		return email;
	}

	
}
