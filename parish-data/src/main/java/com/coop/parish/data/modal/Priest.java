package com.coop.parish.data.modal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@DynamicUpdate(true)
@Table(name="priest_info")
public class Priest {
	
	@Id
	@GeneratedValue
	@Column(name="priest_id")
	private int id;
	
	@Column(name="priest_name", nullable=false)
	private String name;
	
	@Column(name="priest_dob", nullable=false)
	private Date dob;
	
	@Column(name="priest_birth_place", nullable=false)
	private String birthPlace;
	
	@Column(name="priest_education", nullable=false)
	private String education;
	
	@Column(name="priest_specialization")
	private String specialization;
	
	@Column(name="priest_educated_university")
	private String educatedUniversity;
	
	@Column(name="priest_door_no", nullable=false)
	private String doorNo;
	
	@Column(name="priest_street", nullable=false)
	private String street;
	
	@Column(name="priest_village", nullable=false)
	private String village;
	
	@Column(name="priest_taluk")
	private String taluk;
	
	@Column(name="priest_district", nullable=false)
	private String district;
	
	@Column(name="priest_state", nullable=false)
	private String state;
	
	@Column(name="priest_country", nullable=false)
	private String country;
	
	@Column(name="priest_pincode", nullable=false)
	private int pincode;
	
	@Column(name="priest_telephone_no")
	private Long telephoneNo;
	
	@Column(name="priest_mobile_no", nullable=false)
	private Long mobileNo;
	
	@Column(name="priest_email_id", nullable=false)
	private String emailId;
	
	@Column(name="priest_diocese", nullable=false)
	private String diocese;
		
	@Column(name="priest_additional_position")
	private String addditionalPosition;
	
	@Column(name="priest_image")
	private String imageName;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Church.class)
	@JoinColumn(name="church_id")
	private Church church;
		
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="priest", targetEntity=PriestAdditionalInfo.class, optional=false)
	private PriestAdditionalInfo additionalInfo;
	
	@Embedded
	private Audit audit;
	
	public int getId() {
		return id;
	}
	public Audit getAudit() {
		return audit;
	}
	public void setAudit(Audit audit) {
		this.audit = audit;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getEducatedUniversity() {
		return educatedUniversity;
	}
	public void setEducatedUniversity(String educatedUniversity) {
		this.educatedUniversity = educatedUniversity;
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
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
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
	public String getAddditionalPosition() {
		return addditionalPosition;
	}
	public void setAddditionalPosition(String addditionalPosition) {
		this.addditionalPosition = addditionalPosition;
	}
	public PriestAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(PriestAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
		additionalInfo.setPriest(this);
	}
	public Church getChurch() {
		return church;
	}
	
	public void setChurch(Church church) {
		this.church = church;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}

