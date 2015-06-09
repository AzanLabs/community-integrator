package com.coop.parish.web.tests;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionProxyFactory;
import junit.framework.TestCase;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.Dispatcher;
import org.springframework.mock.web.MockServletContext;
import java.util.HashMap;

/**
 * Based on original BaseStrutsTestCase
 * class developed by Zarar Siddiqi
 * See: http://depressedprogrammer.wordpress.com/2007/06/18/unit-testing-struts-2-actions-spring-junit/
 */
public abstract class StrutsBaseTest extends TestCase {


    private Dispatcher dispatcher;
    protected ActionProxy proxy;
    protected static MockServletContext servletContext;


    public StrutsBaseTest(String name) {
        super(name);
    }

    /**
     * Created action class based on namespace and name
     * @param <T>
     * @param clazz Class for which to create Action
     * @param namespace Namespace of action
     * @param actionName Action name
     * @param methodName method in Action class to execute
     * @return Action class
     * @throws Exception Catch-all exception
     */
    @SuppressWarnings("unchecked")
    protected <T> T createAction(Class<T> clazz, String namespace, String actionName, String methodName)
            throws Exception {

        // create a proxy class which is just a wrapper around the action call.
        // The proxy is created by checking the namespace and name against the
        // struts.xml configuration
        proxy = dispatcher.getContainer().getInstance(ActionProxyFactory.class).
                createActionProxy(
                namespace, actionName, methodName, null, true, false);

        // by default, don't pass in any request parameters
        proxy.getInvocation().getInvocationContext().
                setParameters(new HashMap());

        // do not execute the result after executing the action
        proxy.setExecuteResult(false);

        // set the actions context to the one which the proxy is using
        ServletActionContext.setContext(
                proxy.getInvocation().getInvocationContext());

        return (T) proxy.getAction();
        
    }

    protected void setUp() throws Exception {

        HashMap<String, String> params = new HashMap<String, String>();
        dispatcher = new Dispatcher(servletContext, params);
        dispatcher.init();
        Dispatcher.setInstance(dispatcher);
        
    }
}
