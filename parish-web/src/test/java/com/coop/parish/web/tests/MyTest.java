package com.coop.parish.web.tests;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.util.StrutsUtil;
import org.junit.Test;

public class MyTest extends StrutsTestCase{
	
	@Test
	public void testLogin(){
		HttpSession session = request.getSession();
		System.out.println(session.getServletContext().hashCode());
	}
}
