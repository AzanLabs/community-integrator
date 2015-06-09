package com.coop.parish.web.utils;

import java.util.Map;

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
}
