package com.coop.parish.core.beans;

import com.coop.parish.data.modal.Church;

/**
 * Church Bean Class which represents the Church Entity.
 * This Bean has methods to convert Bean to Entity Object and Entity Object to beans,
 * The Entity - Bean , Bean - Entity Conversion does not Consider all the fields involved, 
 * This Bean also has the Struts Validation Annotation, Only common Validations should be present here.
 * Action Specific Validations should be done in validate method.  
 */
public class ChurchBean
{
	private Integer id;
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
	
	public ChurchBean(){}
	
	public ChurchBean(int id){
		this.id = id;
	}
	
	/**
	 * Constructor which Populates Church Bean.
	 * Some fields present in the Entity Objects might be omitted in the beans , ex : Audit fields
	 * @param church entity
	 */
	public ChurchBean(Church church){
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
		}
	}
	
	/**
	 * Converts "this" bean to the relative Entity Object.
	 * The Returned Entity Object is not complete, fields which need not to be modified directly by user are omitted.
	 * @return church entity which wraps the bean values 
	 */
	public Church toBO(){

		Church church = new Church();
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
		
		return church;
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

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
}
