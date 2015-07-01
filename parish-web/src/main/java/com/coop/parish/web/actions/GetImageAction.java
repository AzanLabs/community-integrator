package com.coop.parish.web.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.coop.parish.core.exceptions.ParishException;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * outputs the requested image stream
 * separate methods for separate images of different objects
 * the entire strategy to store and maintain images needs to be revised.
 */
public class GetImageAction extends ActionSupport{
	
	private static final long serialVersionUID = 7396043748663063454L;
	private static final String uploadPath = "/home/sankar/parish"; //need to change this and get path from properties
	private static final String defaultAvathar = uploadPath+"/priests/default.png";
	private String imageId;
	private InputStream fileInputStream;

	File file;
	
	/** outputs the priest profile image , if no image is uploaded default image is outputed*/
	public String getPriestProfileImage(){
		try{
			//get the priest folder and check if the folder (or) file exists
			StringBuilder builder = new StringBuilder(uploadPath).append(File.separator).append("priests");
			String path = builder.append(File.separator).append(imageId).toString();
			File file = new File(path);
			if(!file.exists()){ //if profile image doesnot exists put the default avathar image
				file = new File(defaultAvathar);
			}else{
				file = new File(path);
			}
			fileInputStream = new FileInputStream(file);
		}catch(Exception e){
			e.printStackTrace();
			addActionError("unexpected error");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	
	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
}
