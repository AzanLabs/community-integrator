package com.coop.parish.web.utils;

import java.io.File;

import javax.imageio.ImageIO;

import com.coop.parish.core.exceptions.ParishException;

public class UploadUtils {
	
	public static void checkFileSize(File file,Long limit) throws ParishException{
		if(file == null || !file.exists()){
			throw new ParishException("Invalid Input");
		}
		Long size = file.length();
		size = size/1024;
		if(size > limit){
			throw new ParishException("Maximum File Size Exceeded");
		}
	}
	
	public static void checkFileType(File file, String contentType) throws ParishException{
		//check if contenttype is of image
		if(!contentType.startsWith("image")){
			throw new ParishException("Invalid file format");
		}
		try{
			ImageIO.read(file);
		}catch(Exception e){
			throw new ParishException("The Uploaded file is a corrupted one");
		}
	}
	
}
