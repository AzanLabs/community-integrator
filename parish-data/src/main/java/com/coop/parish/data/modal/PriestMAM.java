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
@Table(name="priest_mam")
public class PriestMAM {
	
	@Id
	@GeneratedValue
	@Column(name="mam_id")
	private int id;
	
	@Column(name="requestor_name")
	private String requestorName;
	
	@Column(name="meeting_date")
	private Date meetingDate;
	
	@Column(name="description")
	private String description;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="status")
	private String status;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="priest_id", nullable=false, updatable=false)
	private Priest priest;
	
	@Embedded
	private Audit audit;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRequestorName() {
		return requestorName;
	}

	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Priest getPriest() {
		return priest;
	}

	public void setPriest(Priest priest) {
		this.priest = priest;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

}
