package com.coop.parish.web.actions;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.service.LoginService;
import com.coop.parish.data.modal.User;
import com.coop.parish.web.beans.UserBean;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private UserBean userBean;
	private Map<String, Object> sessionMap = null;
	
	public String execute(){
		System.out.println();
		if(userBean.getIdentifier() != null && userBean.getPassword() != null){
			User user = new User();
			user.setIdentifier(userBean.getIdentifier());
			user.setPassword(userBean.getPassword());
			LoginService service = ServiceLocator.instance().getLoginService();
			user = service.getUser(user);
			if(user != null && user.getId() > 0){
				System.out.println("success");
				sessionMap.put("isLoggedIn", true);
				sessionMap.put("user", user);
				return "success";
			}else{
				addActionError("Username and password doesn't match");
			}
		}
		return "login";
	}
	
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}	
}
