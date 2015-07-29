package com.coop.parish.core.beans;

import java.util.Date;

import com.coop.parish.data.modal.Priest;

/**
 * Priest Bean Class which represents the Priest Entity.
 * This Bean has methods to convert Bean to Entity Object and Entity Object to beans,
 * The Entity - Bean , Bean - Entity Conversion does not Consider all the fields involved, 
 * This Bean also has the Struts Validation Annotation, Only common Validations should be present here.
 * Action Specific Validations should be done in validate method.  
 */
public class PriestBean {
	
	private Integer id;
	private String name;
	private Date dob; //TODO : check the efficient way of converting to date 
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
	private Integer pincode;
	private Long telephoneNo;
	private Long mobileNo;
	private String emailId;
	private String diocese;
	private String additionalPosition;
	private String additionalInfo;
	private String image;
	private int churchId;
	
	public PriestBean(){}
	/**
	 * Constructor which Populates Bean.
	 * Some fields present in the the Entity Objects might be omitted in the beans , ex : Audit fields
	 * @param Priest entity
	 */
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
			if(priest.getAdditionalInfo() != null){//priest additional info will be small and can be eager fetched
				this.setAdditionalInfo(new String(priest.getAdditionalInfo().getInfo()));
			}
		}
	}
	
	/**
	 * Converts "this" bean to the relative Entity Object.
	 * The Returned Entity Object is not complete, fields which need not to be modified directly by user are omitted.
	 * @return entity which wraps the bean values 
	 */
	public Priest toBO(){
		
		Priest priest = new Priest();
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
		
		return priest;
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

	public String getAdditionalPosition() {
		return additionalPosition;
	}

	public void setAdditionalPosition(String additionalPosition) {
		this.additionalPosition = additionalPosition;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getChurchId() {
		return churchId;
	}

	public void setChurchId(int churchId) {
		this.churchId = churchId;
	}	
}
