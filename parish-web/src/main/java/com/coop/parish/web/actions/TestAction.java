package com.coop.parish.web.actions;

import com.coop.parish.web.beans.ChurchBean;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	private static final long serialVersionUID = 3700648774334798408L;
	private ChurchBean churchBean = new ChurchBean();
	
	public String execute(){
		churchBean.setName("coop");
		churchBean.setAddress("312/201 Kelapalayam st");
		return "success";
	}

	public ChurchBean getChurchBean() {
		return churchBean;
	}

	public void setChurchBean(ChurchBean churchBean) {
		this.churchBean = churchBean;
	}
	
	public void validate(){
		System.out.println("here");
		if(churchBean.getName() == null){
			super.addFieldError("name", "error here null");
		}
	}
	

}
