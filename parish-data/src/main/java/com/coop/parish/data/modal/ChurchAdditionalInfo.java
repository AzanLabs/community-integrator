package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="church_add_info")
@Embeddable
public class ChurchAdditionalInfo 
{
	@Column(name="church_intro")
	private String introduction;
	@Column(name="church_history")
	private String history;
	@Column(name="church_famous_for")
	private String famousFor;
	@Column(name="church_mission")
	private String mission;
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getFamousFor() {
		return famousFor;
	}
	public void setFamousFor(String famousFor) {
		this.famousFor = famousFor;
	}
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}
	
	
}
