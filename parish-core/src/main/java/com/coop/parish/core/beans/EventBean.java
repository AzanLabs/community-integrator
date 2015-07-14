package com.coop.parish.core.beans;

import java.util.Date;

import com.coop.parish.data.modal.Church;
import com.coop.parish.data.modal.Events;
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
	
	public EventBean(Events events){
		if(events != null){
			this.setId(events.getId());
			this.setName(events.getName());
			this.setEventDate(events.getEventDate());
			this.setDescription(events.getDescription());
			this.setDetails(events.getDetails());
		}
	}
	
	public Events toBO(){
		Events events = new Events();
		events.setId(this.getId());
		events.setName(this.getName());
		events.setEventDate(this.getEventDate());
		events.setDescription(this.getDescription());
		events.setDetails(details);
		return events;
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
