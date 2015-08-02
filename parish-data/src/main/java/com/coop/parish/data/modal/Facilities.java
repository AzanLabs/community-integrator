package com.coop.parish.data.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="church_facilities")
public class Facilities {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="name", nullable=false, length=255)
	private String name;
	
	@Column(name="used_for", nullable=false, length=1024)
	private String usedFor;
	
	@Column(name="features", length=1024)
	private String features;
	
	@Column(name="can_be_booked", nullable=false)
	private boolean canBeBooked;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive;
	
	@Column(name="image_group_id", nullable=false)
	private Integer imageGroupId;
	
	@Column(name="church_id",nullable=false, insertable=false, updatable=false)
	private Integer churchId;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="image_group_id", insertable=false, updatable=false)
	private List<Image> images;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="church_id")
	private Church church;
	
	@Embedded
	private Audit audit;

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

	public String getUsedFor() {
		return usedFor;
	}

	public void setUsedFor(String usedFor) {
		this.usedFor = usedFor;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public boolean isCanBeBooked() {
		return canBeBooked;
	}

	public void setCanBeBooked(boolean canBeBooked) {
		this.canBeBooked = canBeBooked;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getImageGroupId() {
		return imageGroupId;
	}

	public void setImageGroupId(Integer imageGroupId) {
		this.imageGroupId = imageGroupId;
	}

	public Integer getChurchId() {
		return churchId;
	}

	public void setChurchId(Integer churchId) {
		this.churchId = churchId;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
}
