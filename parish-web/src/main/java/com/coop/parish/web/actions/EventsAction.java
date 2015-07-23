package com.coop.parish.web.actions;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.EventBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.EventService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

public class EventsAction extends ActionSupport implements SessionAware{
	
	private static final String className = EventsAction.class.getName(); //needed by action support class to serialize
	private static final long serialVersionUID = 3719148551858332373L; //logger
	private final Logger logger = LogManager.getLogger(EventsAction.class);
	private EventBean eventBean; //event bean which will be auto populated from request
	private int id; //event_id needed for read and delete action
	private EventService service = null; //common service needed to communicate
	private Map<String, Object> session;
	
	public String saveEvent(){
		//save event action which needs input from eventbean
		logger.debug("Entering into Method : "+className +" > save event");
		/*try{
			UserBean user = (UserBean)session.get("user");
			service = ServiceLocator.instance().getEventService();
			System.out.println("is user id present"+user.getId());
			eventBean = service.saveEvent(eventBean, user);
		} catch (ParishException e) {
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		} catch (Exception e){
			e.printStackTrace();
			logger.error("Error during save event", e);
			return Action.ERROR;
		}*/
		return Action.SUCCESS;
	}
	
	@SkipValidation
	public String getMyEvent(){
		//gives back the event if found , input is event_id
		try{
			service = ServiceLocator.instance().getEventService();
			eventBean = service.getEventById(id);
		}catch(ParishException e){
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error during getting Event", e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public String editEvent(){
		try{
			UserBean user = (UserBean)session.get("user");
			service = ServiceLocator.instance().getEventService();
			eventBean = service.updateEvent(eventBean, user);
		}catch(ParishException e){
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error during updating event", e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	@SkipValidation
	public String disableEvent(){
		try{
			service = ServiceLocator.instance().getEventService();
			id = service.deleteEvent(id);
		}catch(ParishException e){
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error during deleting event", e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	//getters and setters method used by the struts to inject the params 
	public EventBean getEventBean() {
		return this.eventBean;
	}
	
	@RequiredFieldValidator(key="bean.required")
	@VisitorFieldValidator
	public void setEventBean(EventBean eventBean) {
		this.eventBean = eventBean;
	}
	
	public void validate(){
		//custom validation method
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
