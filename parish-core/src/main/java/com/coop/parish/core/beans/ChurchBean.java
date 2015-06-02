package com.coop.parish.core.beans;

import java.io.Serializable;

import com.coop.parish.data.modal.Address;
import com.coop.parish.data.modal.ChurchInfo;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

public class ChurchBean implements Serializable
{
	private static final long serialVersionUID = -1730684388548572967L;
	private int id;
	private String name;
	private String doorNo;
	private String street;
	private String village;
	private String taluk;
	private String district;
	private String state;
	private String country;
	private Integer pincode;
	private String diocese;
	private String telephoneNo;
	private Long mobileNo;
	private String emailId;
	private ChurchAdditionalInfoBean churchInfo;
	
	public ChurchBean(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@RequiredStringValidator(key="bean.field.required", messageParams={"Church Name"}, message="")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@RequiredStringValidator(key="bean.field.required", messageParams={"Door Number"})
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Street"})
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Town / Village"})
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
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"District"})
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"State"})
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Country"})
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@RequiredFieldValidator(key="bean.field.required", messageParams={"pincode"})
	@IntRangeFieldValidator(key="bean.field.number.invalid", min="000000", max="999999", messageParams={"pincode"})
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Diocese"})
	public String getDiocese() {
		return diocese;
	}
	public void setDiocese(String diocese) {
		this.diocese = diocese;
	}
	
	public String getTelephoneNumber() {
		return telephoneNo;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNo = telephoneNumber;
	}
	
	@RequiredFieldValidator(key="bean.field.required", messageParams={"Mobile Number"})
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobile) {
		this.mobileNo = mobile;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Email Id"})
	@EmailValidator(key="bean.field.email.invalid", messageParams={"Email Id"})
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@RequiredFieldValidator(key="bean.field.required", messageParams={"Church Info"})
	@VisitorFieldValidator
	public ChurchAdditionalInfoBean getChurchInfo() {
		return churchInfo;
	}
	public void setChurchInfo(ChurchAdditionalInfoBean churchAddInfo) {
		this.churchInfo = churchAddInfo;
	}
	
	public ChurchInfo toBO(){
		ChurchInfo church = null;
		if(this != null){
			church = new ChurchInfo();
			church.setId(this.getId());
			church.setName(this.name);
			
			Address address = new Address();
			address.setDoorNo(this.doorNo);
			address.setStreet(this.street);
			address.setVillage(this.village);
			address.setTaluk(this.taluk);
			address.setDistrict(this.district);
			address.setState(this.state);
			address.setCountry(this.country);
			address.setPincode(this.pincode);
			
			church.setAddress(address);
			church.setDiocese(this.diocese);
			church.setTelephoneNumber(this.telephoneNo);
			church.setMobileNo(this.mobileNo);
			church.setEmailId(this.emailId);
			
			if(this.churchInfo != null){
				church.setAdditionalInfo(this.churchInfo.toBO());
			}else{
				church.setAdditionalInfo(null);
			}			
		}
		return church;
	}
}
