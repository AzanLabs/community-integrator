package com.coop.parish.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		if(session.isEmpty()){
			return Action.LOGIN;
		}
		String userRole = null;
		if(session.containsKey("userRole")){
			userRole = (String)((session.get("userRole") != null)?session.get("userRole"):"");
			if("C".equals(userRole)){//userLogged in already
				return invocation.invoke();
			}
		}
		return Action.LOGIN;
	}

}
