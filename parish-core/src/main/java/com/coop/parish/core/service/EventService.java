package com.coop.parish.core.service;

import com.coop.parish.core.beans.EventBean;

public interface EventService extends BaseService{
	
	public EventBean saveEvent(EventBean eventBean) throws Exception;
	
	public EventBean getEventById(int id) throws Exception;
	
	public EventBean updateEvent(EventBean eventBean) throws Exception;
	
	public int deleteEvent(int id) throws Exception;
}
