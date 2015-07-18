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
@Table(name="priest_add_info")
public class PriestAdditionalInfo {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="priest_info")
	@Lob
	private byte[] info;
	
	@Column(name="priest_id", insertable=false, updatable=false)
	private Integer priestId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="priest_id", referencedColumnName="priest_id", nullable=false)
	private Priest priest;

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

	public Integer getPriestId() {
		return priestId;
	}

	public void setPriestId(Integer priestId) {
		this.priestId = priestId;
	}

	public Priest getPriest() {
		return priest;
	}

	public void setPriest(Priest priest) {
		this.priest = priest;
	}

}
