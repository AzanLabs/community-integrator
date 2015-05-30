package com.coop.parish.web.beans;

import javax.persistence.Column;
import javax.persistence.Embedded;

import com.coop.parish.data.modal.Address;

public class ChurchInfoBean 
{
	private int id;
	private String name;
	private String doorNo;
	private String street;
	private String village;
	private String taluk;
	private Integer district;
	private Integer state;
	private Integer country;
	private Integer picode;
	private String diocese;
	private String telephoneNumber;
	private String mobile;
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
	public Integer getDistrict() {
		return district;
	}
	public void setDistrict(Integer district) {
		this.district = district;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getCountry() {
		return country;
	}
	public void setCountry(Integer country) {
		this.country = country;
	}
	public Integer getPicode() {
		return picode;
	}
	public void setPicode(Integer picode) {
		this.picode = picode;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
