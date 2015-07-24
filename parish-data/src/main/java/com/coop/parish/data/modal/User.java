package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int id;

	@Column(name="user_identifier", nullable=false, length=20)
	private String identifier;
	
	@Column(name="user_password", nullable=false, length=50)
	private String password;
	
	@Column(name="user_type", nullable=false)
	private Character type;
	
	@Column(name="priest_id", insertable=false, updatable=false)
	private Integer priestId;
	
	@Column(name="church_id", insertable=false, updatable=false)
	private Integer churchId;
	
	@OneToOne(fetch=FetchType.LAZY, targetEntity=Priest.class)
	@JoinColumn(name="priest_id", nullable=true,referencedColumnName="priest_id")
	private Priest priest;
	
	@OneToOne(fetch=FetchType.LAZY, targetEntity=Church.class)
	@JoinColumn(name="church_id",nullable=true, referencedColumnName="church_id")
	private Church church;
		
	@Column(name="is_active", nullable=false)
	private boolean isActive;
	
	@Embedded
	private Audit audit;
	
	public User(){
		
	}
	
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

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public Priest getPriest() {
		return priest;
	}

	public void setPriest(Priest priest) {
		this.priest = priest;
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

	public Integer getPriestId() {
		return priestId;
	}

	public void setPriestId(Integer priestId) {
		this.priestId = priestId;
	}

	public Integer getChurchId() {
		return churchId;
	}

	public void setChurchId(Integer churchId) {
		this.churchId = churchId;
	}

	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
	}

}
