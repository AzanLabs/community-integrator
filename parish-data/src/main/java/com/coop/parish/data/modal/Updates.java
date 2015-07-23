package com.coop.parish.data.modal;

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
@Table(name="church_updates")
public class Updates {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="details", nullable=false)
	private String details;
	
	@Column(name="church_id", insertable=false, updatable=false)
	private Integer churchId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="church_id")
	private Church church;
	
	@Column(name="is_active", nullable=false)
	private Boolean isActive;
	
	@Embedded
	private Audit audit;
	
	public Updates(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
		if(church.getRecentUpdates() != null) {
			church.getRecentUpdates().add(this);
		}
	}
	
	public Integer getChurchId() {
		return churchId;
	}

	public void setChurchId(Integer churchId) {
		this.churchId = churchId;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
}
