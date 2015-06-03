package com.coop.parish.data.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate(true)
@Table(name="church_info")
public class Church 
{
	@Id
	@GeneratedValue
	@Column(name="church_id")
	private int id;
	
	@Column(name="church_name")
	private String name;
	
	@Column(name="church_door_no")
	private String doorNo ;
	
	@Column(name="church_street")
	private String street;
	
	@Column(name="church_village")
	private String village;
	
	@Column(name="church_taluk")
	private String taluk;
	
	@Column(name="church_district")
	private String district;
	
	@Column(name="church_state")
	private String state;
	
	@Column(name="church_country")
	private String country;
	
	@Column(name="church_pincode")
	private Integer pincode;
	
	@Column(name="church_telephone_no")
	private Long telephoneNo;
	
	@Column(name="church_mobile_no")
	private Long mobileNo;
	
	@Column(name="church_email_id")
	private String emailId;
	
	@Column(name="church_diocese")
	private String diocese;
	
	@Column(name="church_is_active")
	private boolean isActive;

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=true)
	@PrimaryKeyJoinColumn
	private ChurchAdditionalInfo additionalInfo;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="church_id", referencedColumnName="church_id")
	private List<Priest> priests;
	
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

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Long getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(Long telephoneNo) {
		this.telephoneNo = telephoneNo;
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

	public String getDiocese() {
		return diocese;
	}

	public void setDiocese(String diocese) {
		this.diocese = diocese;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public ChurchAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(ChurchAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	public List<Priest> getPriests() {
		return priests;
	}

	public void setPriests(List<Priest> priests) {
		this.priests = priests;
	}
	
}
