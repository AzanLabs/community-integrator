package com.coop.parish.web.beans;

import javax.persistence.Column;
import javax.persistence.Embedded;

import com.coop.parish.data.modal.Address;

public class ChurchAdditionalInfoBean 
{
	private String introduction;
	private String history;
	private String famousFor;
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
