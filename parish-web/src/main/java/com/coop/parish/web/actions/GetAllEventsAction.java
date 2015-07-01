package com.coop.parish.web.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.EventBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.EventService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class GetAllEventsAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = -6870979610045269603L;
	private Map<String, Object> session;
	Map<Integer, EventBean> eventsMap = new HashMap<Integer, EventBean>();
	
	public String getAllEventsOfChurch(){
		List<EventBean> events = null;
		try
		{
			UserBean user = (UserBean)session.get("user");
			EventService service = ServiceLocator.instance().getEventService();
			events = service.getAllEventsOfChurch(user.getChurchId());
			if(events != null){
				for(EventBean e : events){
					eventsMap.put(e.getId(), e);
				}
			}
			return Action.SUCCESS;
			
		}catch(ParishException e){
			e.printStackTrace();
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			addActionError("unexpected error");
			e.printStackTrace();
			return Action.ERROR;
		}
	}
	
	public Map<Integer, EventBean> getEventsMap() {
		return eventsMap;
	}

	public void setEventsMap(Map<Integer, EventBean> eventsMap) {
		this.eventsMap = eventsMap;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
