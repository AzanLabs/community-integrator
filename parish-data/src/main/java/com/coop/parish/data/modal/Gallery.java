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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="church_id", nullable=false, updatable=false)
	private Church church;
	
	@Embedded
	private Audit audit;
}
