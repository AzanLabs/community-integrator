package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="church_gallery")
public class Gallery {

	@Id
	@GeneratedValue
	@Column(name="image_id")
	private int id;
	
	@Column(name="image_name", nullable=false)
	private String imageName;
	
	@Column(name="image_type", nullable=false)
	private String imageType;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive;
	
	@Column(name="church_id", insertable=false, updatable=false)
	private Integer churchId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="church_id", nullable=false, updatable=false)
	private Church church;
	
	@Embedded
	private Audit audit;
	
	public Gallery(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
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
		church.getGallery().add(this);
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
}
