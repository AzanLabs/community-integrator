import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

import com.coop.parish.web.actions.TestAction;
import com.opensymphony.xwork2.ActionProxy;


public class MyTest extends  StrutsTestCase{
	
	@Test
	public void testIt(){
		ActionProxy proxy = getActionProxy("/test");
		TestAction action  =(TestAction)proxy.getAction();
		String result = action.execute();
		action.validate();
		//System.out.println(action.getFieldErrors());
	}

}
