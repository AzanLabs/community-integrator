package com.coop.parish.web.actions;

import java.io.File;

import com.coop.parish.core.beans.PriestBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

public class SavePriestAction extends ActionSupport{

	private static final long serialVersionUID = 2819892671305369437L;
	private PriestBean priestBean;
	
	//for file upload
	private File file;
	private String contentType;
	private String fileName;
	
	public String save(){
		return null;
	}

	public PriestBean getPriestBean() {
		return priestBean;
	}
	
	@RequiredFieldValidator(message="Invalid Request")
	public void setPriestBean(PriestBean priestBean) {
		this.priestBean = priestBean;
	}
	
	public void setUpload(File file){
		this.file = file;
	}
	
	public void setUploadContentType(String contentType){
		this.contentType = contentType;
	}
	
	public void setUploadFileName(String fileName){
		this.fileName = fileName;
	}
}
