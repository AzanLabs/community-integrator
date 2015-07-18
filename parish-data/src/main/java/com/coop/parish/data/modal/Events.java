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
public class Events {
	
	@Id
	@GeneratedValue
	@Column(name="event_id")
	private Integer id;
	
	@Column(name="event_name", nullable=false)
	private String name;
	
	@Column(name="event_start_date", nullable=false)
	private Date eventStartDate;
	
	@Column(name="event_end_date")
	private Date eventEndDate;
	
	@Column(name="event_description")
	private String description;
	
	@Column(name="event_details", nullable=false)
	private String details;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="church_id", nullable=false, updatable=false)
	private Church church;
	
	@Embedded
	private Audit audit;

	public Integer getId() {
		return id;
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

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Date getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
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
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

}