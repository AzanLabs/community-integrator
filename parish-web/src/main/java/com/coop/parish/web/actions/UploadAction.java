package com.coop.parish.web.actions;

import java.io.File;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private File file;
	private String fileName;
	private String type;
	
	public String execute(){
		System.out.println("file name is"+fileName);
		System.out.println("file Type is"+type);
		System.out.println("file is empty"+file);
		return Action.SUCCESS;
	}
	
	public void setUpload(File file){
		this.file = file;
	}
	
	public void setUploadContentType(String contentType){
		this.type = contentType;
	}
	
	public File getFile() {
		return file;
	}

	public String getFileName() {
		return fileName;
	}


	public String getType() {
		return type;
	}

	public void setUploadFileName(String fileName){
		this.fileName = fileName;
	}
}
