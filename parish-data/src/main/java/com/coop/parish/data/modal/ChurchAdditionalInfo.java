package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="church_add_info")
public class ChurchAdditionalInfo 
{	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Lob
	@Column(name="church_info")
	private byte[] info;
	
	@Column(name="church_id",insertable=false, updatable=false)
	private Integer churchId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="church_id", referencedColumnName="church_id", nullable=false)
	private Church church;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getInfo() {
		return info;
	}

	public void setInfo(byte[] info) {
		this.info = info;
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
	
}
