package com.coop.parish.web.actions;

import java.util.Map;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.SessionAware;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.EChurchBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.ChurchService;
import com.coop.parish.core.service.PriestService;
import com.coop.parish.web.utils.WebUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements CookiesAware, SessionAware{

	private static final long serialVersionUID = -572257091820403085L;
	private Map<String, Object> session;
	private Map<String, String> cookies;
	
	public String takeMeToHome(){
		Integer churchId = null;
		Integer priestId = null;
		UserBean user = null;
		ChurchService cService = null;
		PriestService pService = null;
		//check if the user is logged in or not
		if(WebUtils.isUserLoggedIn(session)) { //if user logged take him to respective church
			user = (UserBean)session.get("user");
			churchId = user.getChurchId();
			priestId = user.getPriestId();
			cService = ServiceLocator.instance().getChurchService();
			if(!cService.isChurchSet(churchId)) { //if the church is not yet set
				return "FSTEPSCHURCH";
			}
			pService = ServiceLocator.instance().getPriestService(cService.getEm());
			if(!pService.isPriestSet(priestId)) { //priest profile is not yet set
				return "FSTEPSPRIEST";
			}
		}
		else { //if user not logged in check the preference
			
			//need to implement
			//if preference not set take them to the preference page
		}
		//pull data from church , set it in bean dispatch it
		return "HOME";
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setCookiesMap(Map<String, String> cookies) {
		this.cookies = cookies;
		
	}
	
	
}
