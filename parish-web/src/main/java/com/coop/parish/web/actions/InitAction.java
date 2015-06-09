package com.coop.parish.web.actions;

import java.util.Map;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.SessionAware;

import com.coop.parish.web.utils.WebUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class InitAction extends ActionSupport implements SessionAware, CookiesAware{

	private static final long serialVersionUID = 3634587809899142187L;
	private Map<String, Object> session = null;
	private Map<String, String> cookies = null;
	/*
	 * init action where index reuest is forwarded , bases on 
	 * if logged in or not , is preference set or nor the flow is forwarded to different 
	 * actions
	 */
	public String init(){
		//check all the possible combinations of user accessing this action
		//if user logged in needs to be handled
		//TODO handle if user logged in
		if(WebUtils.isUserLoggedIn(session)){
			return Action.SUCCESS;
		}
		if(WebUtils.isPreferenceSet(cookies)){//preference already set
			return Action.SUCCESS;
		}
		return Action.INPUT;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session =  session;
	}
	
	public void setCookiesMap(Map<String, String> cookies) {
		this.cookies = cookies;
	}

}
