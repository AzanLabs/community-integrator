package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="church_images")
public class Image {
	
	@Id
	@Column(name="image_id")
	@GeneratedValue
	private Integer imageId;
	
	@Column(name="iamge_name", nullable=false, length=255)
	private String imageName;
	
	@Column(name="image_type", nullable=false, length=255)
	private String imageType;
	
	@Column(name="entity", nullable=false, length=255)
	private String entity;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive;
	
	@Column(name="image_size")
	private Integer size;
	
	@Column(name="image_group_id", nullable=false)
	private Integer imageGroupId;
	
	@Embedded
	private Audit audit;
	
	public Image(){}
	
	public Image(Integer id){
		this.imageId = id;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
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

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getImageGroupId() {
		return imageGroupId;
	}

	public void setImageGroupId(Integer imageGroupId) {
		this.imageGroupId = imageGroupId;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
}
