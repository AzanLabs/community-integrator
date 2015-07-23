package com.coop.parish.web.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.LoginService;
import com.coop.parish.web.utils.WebUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 2154215427689539344L;
	private String identifier;
	private String password;
	private Map<String, Object> session;
	private UserBean user;
	
	/**
	 * validates the login attempt
	 * @return String which represents the result name
	 */
	public String login() {
		try {
			//check if the user is already logged in, 
			if(WebUtils.isUserLoggedIn(session)) {
				return Action.SUCCESS;
			}
			//validate login credentials
			LoginService service = ServiceLocator.instance().getLoginService();
			user = service.validateLogin(identifier, password);
			session.put("user", user);
			return Action.SUCCESS;
			
		} catch(ParishException e) {
			
			addActionError(e.getMessage());
			return Action.ERROR;
		} catch(Exception e) {
			
			addActionError("Unexcepted Error Occured. Please Contact System Administrator");
			return Action.ERROR;
		}
	}
	
	/**
	 * clears the current user session
	 */
	@SkipValidation
	public String logout() {
		session.clear();
		return Action.SUCCESS;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	@RequiredStringValidator(message="Identifier is a Required Field")
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPassword() {
		return password;
	}
	
	@RequiredStringValidator(message="Password is a Required Field")
	public void setPassword(String password) {
		this.password = password;
	}

}
