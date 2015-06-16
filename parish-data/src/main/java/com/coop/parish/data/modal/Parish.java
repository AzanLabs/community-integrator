package com.coop.parish.data.modal;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="parish")
public class Parish {
	
	@Id
	@GeneratedValue
	@Column(name="parish_id")
	private Integer id;
	
	@Column(name="parish_name")
	private String name;
	
	@Column(name="parish_door_no")
	private String doorNo ;
	
	@Column(name="parish_street")
	private String street;
	
	@Column(name="parish_village")
	private String village;
	
	@Column(name="parish_taluk")
	private String taluk;
	
	@Column(name="parish_district")
	private String district;
	
	@Column(name="parish_state")
	private String state;
	
	@Column(name="parish_country")
	private String country;
	
	@Column(name="parish_pincode")
	private Integer pincode;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="church_id", referencedColumnName="parish_id")
	private List<Church> church;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public List<Church> getChurch() {
		return church;
	}

	public void setChurch(List<Church> church) {
		this.church = church;
	}
}

