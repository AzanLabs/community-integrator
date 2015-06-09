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

	private static final long serialVersionUID = 2846508119732702465L;
	private Map<String, Object> session;
	private String identifier;
	private String password;
	private LoginService service = null;
	private UserBean user;
	
	public String login(){
		System.out.println("iden:"+this.getIdentifier());
		if(WebUtils.isUserLoggedIn(session)){
			return Action.SUCCESS;
		}
		//authentication and authorization
		if(this.identifier.equals(user.getIdentifier()) && 
				this.password.equalsIgnoreCase(user.getPassword())){
			//correct credentials
			session.put("userRole", user.getRole());
			session.put("user", user);
			if(user.getBelongsTo() != null){
				session.put("isSet", "YES");
				return Action.SUCCESS;
			}else{
				session.put("isSet", "NO");
				return "setup";
			}
		}
		addActionError("Incorrect Password");
		return Action.ERROR;
	}
	
	@SkipValidation
	public String logout(){
		session.clear();
		return Action.SUCCESS;
	}
	
	@Override
	public void validate(){
		
		try {
			service = ServiceLocator.instance().getLoginService();
			user = service.isUserPresent(this.getIdentifier());
		} catch (ParishException e) {
			addFieldError("identifier", "user id doesn't exists");
			e.printStackTrace();
		}
	}
	
	public String getIdentifier() {
		return identifier;
	}
	@RequiredStringValidator(key="bean.field.reuired", messageParams={"asd"})
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getPassword() {
		return password;
	}
	@RequiredStringValidator(key="bean.field.reuired", messageParams={"asd"})
	public void setPassword(String password) {
		this.password = password;
	}

	public void setSession(Map<String, Object> session) {
		this.session  = session;
	}
	
}
