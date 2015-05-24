package com.coop.parish.web.tests;

import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

import com.coop.parish.web.actions.HomeAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;

public class MyTest extends StrutsTestCase{
	
	@Test
	public void testIt() throws Exception{
	
		request.setParameter("homeModal.msg", "haioo");
		request.setParameter("id", "1001");
		
		ActionProxy actionProxy = getActionProxy("/test/home.action");
		HomeAction action =  (HomeAction)actionProxy.getAction();
		action.id = "1001";
		String result = action.execute();
		//System.out.println("is injcted"+action.getHomeModal().getMsg());
 		assertEquals("success", result);	
	}

}
