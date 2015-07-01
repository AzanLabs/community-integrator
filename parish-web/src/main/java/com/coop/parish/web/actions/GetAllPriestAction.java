package com.coop.parish.web.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.PriestBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.PriestService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class GetAllPriestAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = -5618787504288467033L;
	private Logger logger  = LogManager.getLogger(GetAllPriestAction.class);
	private Map<String, Object> session = null;
	private Map<Integer, PriestBean> priestsMap = new HashMap<Integer, PriestBean>();
	
	public String getAllPriestByChurch(){
		logger.info("Entering into GetAllPriest Function");
		List<PriestBean> priests = null;
		try{
				UserBean user = (UserBean)session.get("user");
				PriestService service = ServiceLocator.instance().getPriestService();
				priests = service.getAllPriest(user.getChurchId());
				if(priests != null){
					for(PriestBean p : priests){
						priestsMap.put(p.getId(), p);
					}
				}
			
		}catch(ParishException e){
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			addActionError("Unexcepted error");
			return Action.ERROR;
		}
		return Action.SUCCESS;
		
	}
	public Map<Integer, PriestBean> getPriestsMap() {
		return priestsMap;
	}
	public void setPriestsMap(Map<Integer, PriestBean> priestsMap) {
		this.priestsMap = priestsMap;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
