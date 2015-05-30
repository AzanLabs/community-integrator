package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="church_info")
@Embeddable
public class Address 
{
	@Column(name="church_door_no")
	private String doorNo ;
	@Column(name="church_street")
	private String street;
	@Column(name="church_village")
	private String village;
	@Column(name="church_taluk")
	private String taluk;
	@Column(name="church_district")
	private Integer district;
	@Column(name="church_state")
	private Integer state;
	@Column(name="church_country")
	private Integer country;
	@Column(name="church_pincode")
	private Integer pincode;
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
		return pincode;
	}
	public void setPicode(Integer picode) {
		this.pincode = picode;
	}
	
	
	
}
