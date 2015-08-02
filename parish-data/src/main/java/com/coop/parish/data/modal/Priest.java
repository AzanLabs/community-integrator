package com.coop.parish.data.modal;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="priest_info")
public class Priest {
	
	@Id
	@Column(name="priest_id")
	private Integer id;
	
	@Column(name="priest_name", nullable=false, length=255)
	private String name;
	
	@Column(name="priest_dob", nullable=false)
	private Date dob;
	
	@Column(name="priest_birth_place", nullable=false, length=255)
	private String birthPlace;
	
	@Column(name="priest_education", nullable=false, length=255)
	private String education;
	
	@Column(name="priest_specialization", length=255)
	private String specialization;
	
	@Column(name="priest_educated_university", length=255)
	private String educatedUniversity;
	
	@Column(name="priest_door_no", nullable=false, length=255)
	private String doorNo;
	
	@Column(name="priest_street", nullable=false, length=255)
	private String street;
	
	@Column(name="priest_village", nullable=false, length=255)
	private String village;
	
	@Column(name="priest_taluk", length=255)
	private String taluk;
	
	@Column(name="priest_district", nullable=false, length=255)
	private String district;
	
	@Column(name="priest_state", nullable=false, length=255)
	private String state;
	
	@Column(name="priest_country", nullable=false, length=255)
	private String country;
	
	@Column(name="priest_pincode", nullable=false)
	private Integer pincode;
	
	@Column(name="priest_telephone_no")
	private Long telephoneNo;
	
	@Column(name="priest_mobile_no", nullable=false)
	private Long mobileNo;
	
	@Column(name="priest_email_id", nullable=false, length=50)
	private String emailId;
	
	@Column(name="priest_diocese", nullable=false, length=255)
	private String diocese;
		
	@Column(name="priest_additional_position", length=255)
	private String addditionalPosition;
	
	@Column(name="priest_image_name")
	private String imageName;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="church_id",nullable=false)
	private Integer churchId;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Church.class)
	@JoinColumn(name="church_id",updatable=false, insertable=false)
	private Church church;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="priest", targetEntity=PriestMAM.class)
	private List<PriestMAM> priestMAM;
		
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="priest", targetEntity=PriestAdditionalInfo.class, optional=false)
	private PriestAdditionalInfo additionalInfo;
	
	@Embedded
	private Audit audit;

	public Priest(Integer priestId) {
		this.id = priestId;
	}
		
	public Priest(){
		
	}
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
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

	public String getAddditionalPosition() {
		return addditionalPosition;
	}

	public void setAddditionalPosition(String addditionalPosition) {
		this.addditionalPosition = addditionalPosition;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Integer getChurchId() {
		return churchId;
	}

	public void setChurchId(Integer churchId) {
		this.churchId = churchId;
	}
	
	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
	}

	public List<PriestMAM> getPriestMAM() {
		return priestMAM;
	}

	public void setPriestMAM(List<PriestMAM> priestMAM) {
		this.priestMAM = priestMAM;
	}

	public PriestAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(PriestAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
		additionalInfo.setPriest(this);
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
	
}

