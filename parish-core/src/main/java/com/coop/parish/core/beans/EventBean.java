package com.coop.parish.core.beans;

import java.util.Date;

import com.coop.parish.data.modal.Event;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class EventBean {
	
	private Integer id;
	private String name;
	private Date eventDate;
	private String description;
	private String details;
	private Integer churchId;
	
	public EventBean(){}
	
	public EventBean(int id){
		this.id = id;
	}
	
	public EventBean(Event event){
		if(event != null){
			this.setId(event.getId());
			this.setName(event.getName());
			this.setEventDate(event.getEventDate());
			this.setDescription(event.getDescription());
			this.setDetails(event.getDetails());
			this.setChurchId(event.getChurchId());
		}
	}
	
	public Event toBO(){
		Event event = new Event();
		event.setId(this.getId());
		event.setName(this.getName());
		event.setEventDate(this.getEventDate());
		event.setDescription(this.getDescription());
		event.setDetails(details);
		event.setChurchId(this.getChurchId());
		return event;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"N"}, message="")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//@RequiredFieldValidator(key="bean.field.required", messageParams={"N"}, message="")
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"N"}, message="")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"N"}, message="")
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public Integer getChurchId() {
		return churchId;
	}
	public void setChurchId(Integer churchId) {
		this.churchId = churchId;
	}
}
