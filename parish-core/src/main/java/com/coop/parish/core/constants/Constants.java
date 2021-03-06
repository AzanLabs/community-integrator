package com.coop.parish.core.constants;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class Constants {
	
	public static final String PARAM_NULL_MSG = "Input Params should not be null"; 
	public static final String NO_SUCH_OBJECT = "The Entity with the given id does not exixts.";
	public static final String AUTHENTICATION_FAILED = "The User Account doesn't exists";
	public static final String AUTHORIZATION_FAILED = "Invalid Password";
	
	private static final StringBuilder parishFolder = new StringBuilder(FileUtils.getUserDirectoryPath()).append(File.separatorChar).append("parish");
	public static final String PARISH_FOLDER = parishFolder.toString();
	public static final String PRIEST_FOLDER = parishFolder.append(File.separatorChar).append("priests").toString();
			
}
