package com.coop.parish.web.utils;

import java.util.Map;

import com.coop.parish.core.exceptions.ParishException;

public class WebUtils {
	
	public static boolean isUserLoggedIn(Map<String, Object> session){
		boolean flag = false;
		if(session == null || session.isEmpty()){
			return flag;
		}
		
		if(session.containsKey("userRole")){
			String userRole = (String)((session.get("userRole") != null)?session.get("userRole"):"");
			if(!userRole.isEmpty()){//userLogged in already
				flag = true;
			}
		}
		return flag;
	}
	
	public static boolean isPreferenceSet(Map<String, String> cookies){
		boolean flag = false;
		if(cookies == null || cookies.isEmpty()){
			return flag;
		}
		if(cookies.containsKey("churchId")){
			String churchId = (String)((cookies.get("userRole") != null)?cookies.get("userRole"):"");
			if(!churchId.isEmpty()){//preference already set
				flag = true;
			}
		}
		return flag;
	}
	
	public static Integer getWeightage(String userRole) throws ParishException{
		if(userRole == null){
			throw new ParishException("invalid request");
		}
		Integer weightage = null;
		if("A".equalsIgnoreCase(userRole)){
			weightage = 4;
			return weightage;
		}
		if("PA".equalsIgnoreCase(userRole)){
			weightage = 3;
			return weightage;
		}
		if("CA".equalsIgnoreCase(userRole)){
			weightage = 2;
			return weightage;
		}
		if("CU".equalsIgnoreCase(userRole)){
			weightage = 1;
			return weightage;
		}
		if(weightage == null){
			throw new ParishException("Invalid Request");
		}
		return weightage;
	}
	
	public static String getResultString(Integer weightage, boolean isSet){
		String resultString = null;
		//redirect based on role and isset
		switch(weightage){
			case 4 : resultString = "admin";
						break;
			case 3 : resultString = "padmin";
						break;
			case 2 : case 1 : if(isSet){resultString = "home";} else {resultString = "setup";};
						break;
		}
		return resultString;
	}
	
}
