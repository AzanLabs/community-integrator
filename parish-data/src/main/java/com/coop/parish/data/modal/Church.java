package com.coop.parish.data.modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="church")
public class Church {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="address_fk")
	/**
	 * TODO : check embedded and fetch type associations for address entity
	 */
	private Address address;
	private String diocese;
	@Column(name="landline_no")
	private Long landlineNo;
	@Column(name="mobile_no")
	private Long mobileNo;
	@Column(name="email_id")
	private String emailId;
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDiocese() {
		return diocese;
	}
	public void setDiocese(String diocese) {
		this.diocese = diocese;
	}
	public Long getLandlineNo() {
		return landlineNo;
	}
	public void setLandlineNo(Long landlineNo) {
		this.landlineNo = landlineNo;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
