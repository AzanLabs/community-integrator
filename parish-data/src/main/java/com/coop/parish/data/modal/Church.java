package com.coop.parish.data.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="church_info")
public class Church 
{
	@Id
	@Column(name="church_id")
	private int id;
	
	@Column(name="church_name", nullable=false, length=1024)
	private String name;
	
	@Column(name="church_door_no", nullable=false, length=50)
	private String doorNo ;
	
	@Column(name="church_street", nullable=false, length=255)
	private String street;
	
	@Column(name="church_village", nullable=false, length=255)
	private String village;
	
	@Column(name="church_taluk", length=255)
	private String taluk;
	
	@Column(name="church_district", nullable=false, length=255)
	private String district;
	
	@Column(name="church_state", nullable=false, length=255)
	private String state;
	
	@Column(name="church_country", nullable=false, length=255)
	private String country;
	
	@Column(name="church_pincode", nullable=false)
	private Integer pincode;
	
	@Column(name="church_telephone_no")
	private Long telephoneNo;
	
	@Column(name="church_mobile_no", nullable=false)
	private Long mobileNo;
	
	@Column(name="church_email_id", nullable=false, length=100)
	private String emailId;
	
	@Column(name="church_diocese", nullable=false, length=255)
	private String diocese;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive;

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, optional=false, mappedBy="church",targetEntity=ChurchAdditionalInfo.class)
	private ChurchAdditionalInfo additionalInfo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="church", targetEntity=Priest.class)
	private List<Priest> priests;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="church", targetEntity=Events.class)
	private List<Events> events;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="church", targetEntity=Updates.class)
	private List<Updates> recentUpdates;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="church", targetEntity=BibleVerses.class)
	private List<BibleVerses> bibleWords;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="church", targetEntity=Gallery.class)
	private List<Gallery> gallery;
	
	@Embedded
	private Audit audit;
	
	public Church(){ }
	
	public Church(Integer churchId) {
		this.id = churchId;
	}

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public ChurchAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(ChurchAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
		additionalInfo.setChurch(this);
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
	public List<Priest> getPriests() {
		return priests;
	}

	public void setPriests(List<Priest> priests) {
		this.priests = priests;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

	public List<Updates> getRecentUpdates() {
		return recentUpdates;
	}

	public void setRecentUpdates(List<Updates> recentUpdates) {
		this.recentUpdates = recentUpdates;
	}

	public List<BibleVerses> getBibleWords() {
		return bibleWords;
	}

	public void setBibleWords(List<BibleVerses> bibleWords) {
		this.bibleWords = bibleWords;
	}
	
	public List<Gallery> getGallery() {
		return gallery;
	}

	public void setGallery(List<Gallery> gallery) {
		this.gallery = gallery;
	}
}