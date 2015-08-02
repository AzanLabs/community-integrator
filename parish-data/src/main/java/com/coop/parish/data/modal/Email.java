package com.coop.parish.data.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="email_archive")
public class Email {
	
	@Id
	@GeneratedValue
	@Column(name="email_id")
	private Integer id;
	
	@Column(name="send_to", nullable=false, length=100)
	private String sendTo;

	@Column(name="subject", nullable=false, length=255)
	private String subject;
	
	@Lob
	@Column(name="message", nullable=false)
	private String message;
	
	@Column(name="email_status", nullable=false, length=20)
	private String status;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive;
	
	@Column(name="created_on", nullable=false)
	private Date createdOn;
	
	@Column(name="user_id",nullable=false)
	private Integer userId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id",insertable=false, updatable=false)
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
}
