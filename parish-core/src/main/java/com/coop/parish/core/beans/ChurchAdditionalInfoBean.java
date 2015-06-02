package com.coop.parish.core.beans;

import com.coop.parish.data.modal.ChurchAdditionalInfo;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class ChurchAdditionalInfoBean {
	
	private int id;
	private String info;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Church Info"})
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public ChurchAdditionalInfo toBO(){
		ChurchAdditionalInfo info = new ChurchAdditionalInfo();
		info.setInfo(this.info);
		return info;
	}
}
