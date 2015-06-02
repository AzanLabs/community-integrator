package com.coop.parish.web.actions;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.ChurchBean;
import com.coop.parish.core.service.ChurchService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

public class ChurchAction extends ActionSupport{

	//needed by action support class to serialize
	private static final long serialVersionUID = 3719148551858332373L;
	
	//church bean which will be auto populated from request
	private ChurchBean church;
	
	public String saveChurch(){
		System.out.println("saving church "+church.getName());
		ChurchService service = ServiceLocator.instance().getChurchService();
		church = service.saveChurch(church);
		return "success";
	}


	//getters and setters method used by the struts to inject the params 
	public ChurchBean getChurch() {
		return church;
	}
	
	@RequiredFieldValidator(key="bean.required")
	@VisitorFieldValidator
	public void setChurch(ChurchBean church) {
		this.church = church;
	}
	
	//custom validation method
	public void validate(){
		super.validate();
		if(this.getChurch() == null){
			addActionError("Invalid Input");
		}
	}
}
