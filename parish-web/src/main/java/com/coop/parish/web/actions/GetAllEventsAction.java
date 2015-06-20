package com.coop.parish.web.actions;

import java.util.ArrayList;
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
	List<EventBean> events = new ArrayList<EventBean>();
	
	public String getAllEventsOfChurch(){
		try
		{
			UserBean user = (UserBean)session.get("user");
			EventService service = ServiceLocator.instance().getEventService();
			events = service.getAllEventsOfChurch(user.getChurchId());
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
	
	public List<EventBean> getEvents() {
		return events;
	}

	public void setEvents(List<EventBean> events) {
		this.events = events;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
