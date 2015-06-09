package com.coop.parish.web.tests;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.StrutsTestCase;
//import org.junit.Test;

import com.coop.parish.web.actions.LoginAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;

public class ActionTest /*extends StrutsTestCase*/{
	
	Map<String, Object> session = new HashMap<String, Object>();
	Map<String, String> cookies = new HashMap<String, String>();
	
	/*@Test
	public void testLogin(){
		ActionProxy proxy = getActionProxy("./actionLogin");
		LoginAction action = (LoginAction)proxy.getAction();
		action.setIdentifier("admin");
		action.setPassword("admin");
		action.setSession(session);
		action.validate();
		if(action.getFieldErrors().isEmpty()){
			String result = action.login();
			assertEquals(result, Action.SUCCESS);
		}
		System.out.println(action.getFieldErrors().toString());
	}*/
	
}
