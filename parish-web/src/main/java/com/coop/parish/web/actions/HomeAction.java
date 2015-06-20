package com.coop.parish.web.actions;

import java.util.Map;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.SessionAware;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.EChurchBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.ChurchService;
import com.coop.parish.web.utils.WebUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements CookiesAware, SessionAware{

	private static final long serialVersionUID = -572257091820403085L;
	
	private Map<String, String> cookies;
	private Map<String, Object> session;
	private Integer churchId;
	private EChurchBean eChurchBean = null;
	private ChurchService service = null;
	
	public String execute(){
		try {
			if(this.churchId == null){
				setChurchIdFromRequest();
			}
			service = ServiceLocator.instance().getChurchService();
			eChurchBean = service.getEntireChurch(churchId);
		} catch (ParishException e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return Action.ERROR;
		} catch (Exception e){
			e.printStackTrace();
			addActionError("Internal Server Error");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public void setCookiesMap(Map<String, String> cookies) {
		this.cookies = cookies;	
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public int getChurchId() {
		return churchId;
	}
	public void setChurchId(int churchId) {
		this.churchId = churchId;
	}
	
	public EChurchBean geteChurchBean() {
		return eChurchBean;
	}
	public void seteChurchBean(EChurchBean eChurchBean) {
		this.eChurchBean = eChurchBean;
	}
	
	private void setChurchIdFromRequest() throws ParishException{
		if(WebUtils.isUserLoggedIn(session)){
			if(session.containsKey("user")){
				UserBean user= (UserBean)session.get("user");
				this.churchId = user.getChurchId();
			}
		}
		if(WebUtils.isPreferenceSet(cookies)){
			this.churchId = Integer.valueOf(cookies.get("churchId"));
		}
		if(churchId == null){
			throw new ParishException("Invalid Request");
		}
	}
}
