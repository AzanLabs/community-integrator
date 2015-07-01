package com.coop.parish.core.beans;

import java.util.Date;

import com.coop.parish.data.modal.Priest;
import com.coop.parish.data.modal.PriestAdditionalInfo;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class PriestBean {
	
	private int id;
	private String name;
	private Date dob;
	private String birthPlace;
	private String education;
	private String specialization;
	private String educatedUniversity;
	private String doorNo;
	private String street;
	private String village;
	private String taluk;
	private String district;
	private String state;
	private String country;
	private int pincode;
	private Long telephoneNo;
	private Long mobileNo;
	private String emailId;
	private String diocese;
	private String additionalPosition;
	private String additionalInfo;
	private String image;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	private int churchId;
	
	public PriestBean(){}
	
	public PriestBean(int id){
		this.id = id;
	}
	
	public PriestBean(Priest priest){
		if(priest != null){
			this.setId(priest.getId());
			this.setName(priest.getName());
			this.setDob(priest.getDob());
			this.setBirthPlace(priest.getBirthPlace());
			this.setEducation(priest.getEducation());
			this.setSpecialization(priest.getSpecialization());
			this.setEducatedUniversity(priest.getEducatedUniversity());

			this.setDoorNo(priest.getDoorNo());
			this.setStreet(priest.getStreet());
			this.setVillage(priest.getVillage());
			this.setTaluk(priest.getTaluk());
			this.setDistrict(priest.getDistrict());
			this.setState(priest.getState());
			this.setCountry(priest.getCountry());
			this.setPincode(priest.getPincode());

			this.setTelephoneNo(priest.getTelephoneNo());
			this.setMobileNo(priest.getMobileNo());
			this.setEmailId(priest.getEmailId());
			this.setDiocese(priest.getDiocese());
			this.setAdditionalPosition(priest.getAddditionalPosition());
			this.setImage(priest.getImageName());
			if(priest.getAdditionalInfo() != null){
				this.setAdditionalInfo(priest.getAdditionalInfo().getInfo());
			}
		}
	}
	
	public Priest toBO(){
		Priest priest = null;
		if(this != null){
			priest = new Priest();
			priest.setId(this.getId());
			priest.setName(this.getName());
			priest.setDob(this.getDob());
			priest.setBirthPlace(this.getBirthPlace());
			priest.setEducation(this.getEducation());
			priest.setSpecialization(this.getSpecialization());
			priest.setEducatedUniversity(this.getEducatedUniversity());

			priest.setDoorNo(this.getDoorNo());
			priest.setStreet(this.getStreet());
			priest.setVillage(this.getVillage());
			priest.setTaluk(this.getTaluk());
			priest.setDistrict(this.getDistrict());
			priest.setState(this.getState());
			priest.setCountry(this.getCountry());
			priest.setPincode(this.getPincode());
			
			priest.setTelephoneNo(this.getTelephoneNo());
			priest.setMobileNo(this.getMobileNo());
			priest.setEmailId(this.getEmailId());
			priest.setDiocese(this.getDiocese());
			priest.setAddditionalPosition(this.getAdditionalPosition());
			
			PriestAdditionalInfo info = null;
			if(this.getAdditionalInfo() != null){
				info = new PriestAdditionalInfo();
				info.setInfo(this.getAdditionalInfo());
			}
			priest.setAdditionalInfo(info);
		}
		return priest;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//@RequiredFieldValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getEducatedUniversity() {
		return educatedUniversity;
	}
	public void setEducatedUniversity(String educatedUniversity) {
		this.educatedUniversity = educatedUniversity;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getTaluk() {
		return taluk;
	}
	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@RequiredFieldValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	@RequiredFieldValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public Long getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(Long telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	
	@RequiredFieldValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	@EmailValidator(key="bean.email.invalid", messageParams={"Email Id"})
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getDiocese() {
		return diocese;
	}
	public void setDiocese(String diocese) {
		this.diocese = diocese;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getAdditionalPosition() {
		return additionalPosition;
	}
	public void setAdditionalPosition(String additionalPosition) {
		this.additionalPosition = additionalPosition;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"not_working"}, message="")
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
}
