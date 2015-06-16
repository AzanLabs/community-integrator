package com.coop.parish.web.utils;

import java.io.File;

import com.coop.parish.core.exceptions.ParishException;

public class UploadUtils {
	
	private static void checkFileSize(File file,Long limit) throws ParishException{
		if(file == null || !file.exists()){
			throw new ParishException("Invalid Input");
		}
		Long size = file.length();
		size = size/1024;
		if(size > limit){
			throw new ParishException("Maximum File Size Exceeded");
		}
	}
	
	private static void checkFileType(String contentType, String expected) throws ParishException{
		if(expected == null || contentType == null || contentType.isEmpty()){
			throw new ParishException("Invalid Input");
		}
		if(!expected.equalsIgnoreCase(contentType)){
			throw new ParishException("Image Type should be only "+expected);
		}
	}
	
}
