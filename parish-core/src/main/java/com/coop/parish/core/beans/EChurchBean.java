package com.coop.parish.core.beans;

import java.util.List;

import com.coop.parish.data.modal.Church;
import com.coop.parish.data.modal.ChurchAdditionalInfo;
import com.coop.parish.data.modal.Event;
import com.coop.parish.data.modal.Priest;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class EChurchBean {
	
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
	private Long telephoneNo;
	private Long mobileNo;
	private String emailId;
	private String diocese;
	private String additionalInfo;
	private List<Priest> priests;
	private List<Event> events;
	
	public EChurchBean(){}
	
	public EChurchBean(int id){
		this.id = id;
	}
	
	public EChurchBean(Church church){
		if(church != null){
			this.setId(church.getId());
			this.setName(church.getName());
			
			this.setDoorNo(church.getDoorNo());
			this.setStreet(church.getStreet());
			this.setVillage(church.getVillage());
			this.setTaluk(church.getTaluk());
			this.setDistrict(church.getDistrict());
			this.setState(church.getState());
			this.setCountry(church.getCountry());
			this.setPincode(church.getPincode());
			
			this.setTelephoneNo(church.getTelephoneNo());
			this.setMobileNo(church.getMobileNo());
			this.setEmailId(church.getEmailId());
			this.setDiocese(church.getDiocese());
			if(church.getAdditionalInfo() != null){
				this.setAdditionalInfo(church.getAdditionalInfo().getInfo());
			}
			if(!church.getPriests().isEmpty()){
				this.setPriests(church.getPriests());
			}
			if(!church.getEvents().isEmpty()){
				this.setEvents(church.getEvents());
			}
			
		}
	}
	
	public Church toBO(){
		Church church = null;
		if(this != null){
			church = new Church();
			church.setId(this.getId());
			church.setName(this.getName());
			
			church.setDoorNo(this.getDoorNo());
			church.setStreet(this.getStreet());
			church.setVillage(this.getVillage());
			church.setTaluk(this.getTaluk());
			church.setDistrict(this.getDistrict());
			church.setState(this.getState());
			church.setCountry(this.getCountry());
			church.setPincode(this.getPincode());
			
			church.setTelephoneNo(this.getTelephoneNo());
			church.setMobileNo(this.getMobileNo());
			church.setEmailId(this.getEmailId());
			church.setDiocese(this.getDiocese());
			
			ChurchAdditionalInfo info = null;
			if(this.additionalInfo != null){
				info = new ChurchAdditionalInfo();
				info.setInfo(this.getAdditionalInfo());	
			}
			church.setAdditionalInfo(info);
		}
		return church;
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
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Door Number"}, message="")
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	@RequiredStringValidator(key="bean.field.required", messageParams={"Street"}, message="")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Village/Town"}, message="")
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Taluk"}, message="")
	public String getTaluk() {
		return taluk;
	}
	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"District"}, message="")
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"State"}, message="")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Country"}, message="")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@RequiredFieldValidator(key="bean.field.required", messageParams={"Pincode"}, message="")
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	@RequiredFieldValidator(key="bean.field.required", messageParams={"Telephone Number"}, message="")
	public Long getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(Long telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	
	@RequiredFieldValidator(key="bean.field.required", messageParams={"Mobile Number"}, message="")
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@RequiredFieldValidator(key="bean.field.required", messageParams={"Email"}, message="")
	@EmailValidator(key="bean.email.invalid", messageParams={"Email Id"})
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Diocese"}, message="")
	public String getDiocese() {
		return diocese;
	}
	public void setDiocese(String diocese) {
		this.diocese = diocese;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Church Info"}, message="")
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public List<Priest> getPriests() {
		return priests;
	}

	public void setPriests(List<Priest> priests) {
		this.priests = priests;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}
