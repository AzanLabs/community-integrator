package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="priest_add_info")
public class PriestAdditionalInfo {
	
	@Id
	@GeneratedValue
	@Column(name="priest_id")
	private int id;
	
	@Column(name="priest_info")
	private String info;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
