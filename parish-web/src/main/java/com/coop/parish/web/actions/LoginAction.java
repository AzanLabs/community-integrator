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
		try{
			Integer weightage = null;
			boolean isSet = false;
			if(WebUtils.isUserLoggedIn(session)){
				weightage = Integer.valueOf(session.get("roleWeight").toString());
				isSet = "YES".equals(String.valueOf(session.get("isSet")));
				return WebUtils.getResultString(weightage, isSet);
			}
			//authentication and authorization
			else if(this.identifier.equals(user.getIdentifier()) && this.password.equalsIgnoreCase(user.getPassword())){
				weightage = WebUtils.getWeightage(user.getRole());
				//TODO : add user related details (address, name etc)
				session.put("user", user);
				session.put("roleWeight", weightage);
				
				//is church web site set or not , redirect based on it
				if(user.getChurchId() != null){
					isSet = true;
					session.put("isSet", "YES");
				}else{
					session.put("isSet", "NO");
				}
				return WebUtils.getResultString(weightage, isSet);
			}
			addActionError("Incorrect Password");
			return Action.ERROR;
		}catch(ParishException e){
			e.printStackTrace();
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			e.printStackTrace();
			addActionError("Unexcepted error");
			return Action.ERROR;
		}
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
			e.printStackTrace();
			addFieldError("identifier", "user id doesn't exists");
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
