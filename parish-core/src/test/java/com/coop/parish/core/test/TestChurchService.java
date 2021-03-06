package com.coop.parish.core.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.ChurchBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.ChurchService;
import com.coop.parish.core.service.FacilitiesService;

public class TestChurchService {
	
	ChurchService service = null;
	ChurchBean churchBean = null;
	UserBean user = null;
	
	@BeforeClass
	public void setUp(){
		service = ServiceLocator.instance().getChurchService();
		
		
		churchBean = new ChurchBean();
		churchBean.setName("coop");
		churchBean.setDoorNo("608");
		churchBean.setStreet("Empty Street");
		churchBean.setVillage("sare homes");
		churchBean.setTaluk("thiruporur");
		churchBean.setDistrict("Kancheepuram");
		churchBean.setState("TN");
		churchBean.setCountry("india");
		churchBean.setPincode(987654);
		churchBean.setMobileNo(123456789L);
		churchBean.setTelephoneNo(123456789L);
		churchBean.setEmailId("aaa@bbb.com");
		churchBean.setDiocese("d");
		churchBean.setAdditionalInfo("<p>Success</p>");
		
		user = new UserBean();
		user.setId(1001);
		user.setChurchId(2001);
	}
	
	@Test(enabled=false)
	public void checkSaveChurch() throws ParishException{
		ChurchBean cBean = service.saveChurchFirstSteps(churchBean, user);
		Assert.assertNotNull(cBean.getId(), "should not be null");
	}
	
	@Test(enabled = false)
	public void testUpdateChurchDetails() throws Exception {
		churchBean.setId(2001);
		ChurchBean cBean = service.updateChurchDetails(churchBean, user);
		System.out.println(cBean.getAdditionalInfo());
		
	}
	
	@Test(enabled=false)
	public void testsaveF(){
		FacilitiesService service = ServiceLocator.instance().getFacilitiesService();
		service.saveFacility();
	}
}
