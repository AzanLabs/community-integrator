package com.coop.parish.data.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="church_events")
public class Event {
	
	@Id
	@GeneratedValue
	@Column(name="event_id")
	private Integer id;
	
	@Column(name="event_name")
	private String name;
	
	@Column(name="event_date_time")
	private Date eventDate;
	
	@Column(name="event_description")
	private String description;
	
	@Column(name="event_details")
	private String details;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="church_id")
	private Church church;
	
	@Embedded
	private Audit audit;
	
	public Integer getId() {
		return id;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
		if(church.getEvents() != null && !church.getEvents().contains(this)){
			church.getEvents().add(this);
		}
	}
	
}
