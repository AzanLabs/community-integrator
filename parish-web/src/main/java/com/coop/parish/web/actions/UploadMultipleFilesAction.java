package com.coop.parish.web.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UploadMultipleFilesAction extends ActionSupport{

	private static final long serialVersionUID = 91948373313269460L;
	
	private List<File> files = new ArrayList<File>();
	private List<String> contentTypes = new ArrayList<String>();
	private List<String> fileNames = new ArrayList<String>();
	
	public String execute(){
		try{
			System.out.println("the number of files is "+files.size());
			System.out.println("the last file name is "+fileNames.toString());
			System.out.println("the forst filename is"+fileNames.get(0));
		}catch(Exception e){
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public void setUpload(List<File> files){
		this.files = files;
	}
	
	public void setUploadContentType(List<String> contentTypes){
		this.contentTypes = contentTypes;
	}
	
	public void setUploadFileName(List<String> fileNames){
		this.fileNames = fileNames;
	}
	
}
