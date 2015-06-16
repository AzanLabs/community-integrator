package com.coop.parish.web.interceptor;

import java.util.Map;

import com.coop.parish.web.utils.WebUtils;
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
		if(WebUtils.isUserLoggedIn(session)){
			return invocation.invoke();
		}
		return Action.LOGIN;
	}

}
