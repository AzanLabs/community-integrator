package com.coop.parish.core.service;

import java.util.List;

import com.coop.parish.core.beans.EventBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;

public interface EventService extends BaseService{
	
	/**
	 * This Method Saves the Event
	 * @param eventBean the details to persist
	 * @param user current user in session
	 * @return persisted event
	 * @throws ParishException if invalid input is passed
	 */
	public EventBean saveEvents(EventBean eventBean, UserBean user) throws ParishException;
	
	public EventBean getEventById(int id) throws Exception;
	
	public EventBean updateEvent(EventBean eventBean, UserBean user) throws Exception;
	
	public int deleteEvent(Integer id) throws Exception;
	
	public List<EventBean> getAllEventsOfChurch(Integer churchId) throws Exception;
}
