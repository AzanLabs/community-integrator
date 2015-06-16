package com.coop.parish.web.actions;

import java.util.Map;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.SessionAware;

import com.coop.parish.core.exceptions.ParishException;
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
		try{
			if(WebUtils.isUserLoggedIn(session)){
				//get the role and isset and redirect accordingly
				Integer roleWeight = WebUtils.getWeightage(session.get("roleWeight").toString());
				boolean isSet = "YES".equals(String.valueOf(session.get("isSet")));
				return WebUtils.getResultString(roleWeight, isSet);
			}
			
			//if user not logged in,
			if(WebUtils.isPreferenceSet(cookies)){//check if churchid is set in cookie
				return "phome";
			}
			//redirect to preferences page if preferences not set
			return "preferences";
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
	
	public void setSession(Map<String, Object> session) {
		this.session =  session;
	}
	
	public void setCookiesMap(Map<String, String> cookies) {
		this.cookies = cookies;
	}
}
