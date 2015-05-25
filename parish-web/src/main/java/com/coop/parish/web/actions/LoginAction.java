package com.coop.parish.web.actions;

import javax.servlet.http.HttpSession;
import com.coop.parish.web.beans.UserBean;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private UserBean userBean;
	private HttpSession session;
	
	public String execute(){
		System.out.println();
		if(userBean != null){
			if("aaa@bbb.com".equalsIgnoreCase(userBean.geteMail()) && "admin".equalsIgnoreCase(userBean.getPassword())){
				return "success";
			}
		}
		return "error";
	}
	
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}	
}
