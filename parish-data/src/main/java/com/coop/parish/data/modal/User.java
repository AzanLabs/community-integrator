package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int id;

	@Column(name="user_identifier")
	private String identifier;
	
	@Column(name="user_password")
	private String password;
	
	@Column(name="user_role")
	private String role;
	
	@Column(name="parish_id")
	private Integer parishId;
	
	@Column(name="church_id")
	private Integer churchId;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Embedded
	private Audit audit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getParishId() {
		return parishId;
	}

	public void setParishId(Integer parishId) {
		this.parishId = parishId;
	}

	public Integer getChurchId() {
		return churchId;
	}

	public void setChurchId(Integer churchId) {
		this.churchId = churchId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
		
}
