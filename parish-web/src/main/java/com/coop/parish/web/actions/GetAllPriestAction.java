package com.coop.parish.web.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.PriestBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.PriestService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class GetAllPriestAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = -5618787504288467033L;
	private Logger logger  = LogManager.getLogger(GetAllPriestAction.class);
	private Map<String, Object> session = null;
	private List<PriestBean> priests = new ArrayList<PriestBean>();
	
	public String getAllPriestByChurch(){
		logger.info("Entering into GetAllPriest Function");
		try{
			if(session.containsKey("churchId")){
				Integer churchId = Integer.valueOf(session.get("churchId").toString());
				PriestService service = ServiceLocator.instance().getPriestService();
				setPriests(service.getAllPriest(churchId));
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
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public List<PriestBean> getPriests() {
		return priests;
	}
	public void setPriests(List<PriestBean> priests) {
		this.priests = priests;
	}
}
