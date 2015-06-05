package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="church_add_info")
public class ChurchAdditionalInfo 
{	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int church_id;
	
	@Column(name="church_info")
	private String info;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="church_id", referencedColumnName="church_id", nullable=false)
	private Church church;


	public int getChurch_id() {
		return church_id;
	}

	public void setChurch_id(int church_id) {
		this.church_id = church_id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
	}
}
