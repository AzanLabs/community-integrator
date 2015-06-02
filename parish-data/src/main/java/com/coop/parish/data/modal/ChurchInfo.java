package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="church_info")
public class ChurchInfo 
{
	@Id
	@GeneratedValue
	@Column(name="church_id")
	private int id;
	@Column(name="church_name", nullable=false)
	private String name;
	@Embedded
	private Address address;
	@Column(name="church_diocese")
	private String diocese;
	@Column(name="church_telephone_no")
	private String telephoneNumber;
	@Column(name="church_mobile")
	private Long mobileNo;
	@Column(name="church_email_id")
	private String emailId;
	/**
	 * TODO : need to map
	 */
	private ChurchAdditionalInfo additionalInfo;
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
	public String getDiocese() {
		return diocese;
	}
	public void setDiocese(String diocese) {
		this.diocese = diocese;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobile) {
		this.mobileNo = mobile;
	}
	public String getEmailId() {
		return emailId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public ChurchAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(ChurchAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
