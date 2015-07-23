package com.coop.parish.core.test;

import java.io.File;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.FileBean;
import com.coop.parish.core.beans.PriestBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.service.PriestService;

public class TestPriestService {
	
	PriestService service = ServiceLocator.instance().getPriestService();
	PriestBean priestBean = null;
	UserBean user = null;
	FileBean fileBean = null;
	
	@BeforeClass
	public void setUp(){
		 priestBean = new PriestBean();
		 priestBean.setName("priest");
		 priestBean.setDoorNo("608");
		 priestBean.setStreet("Empty Street");
		 priestBean.setTaluk("Sare Homes");
		 priestBean.setVillage("sare homes");
		 priestBean.setDistrict("Kancheepuram");
		 priestBean.setState("TN");
		 priestBean.setCountry("IN");
		 priestBean.setPincode(607213);
		 
		 priestBean.setEducation("Uneducated");
		 priestBean.setEducatedUniversity("No university");
		 priestBean.setSpecialization("no specialization");
		 
		 priestBean.setDob(new Date());
		 priestBean.setBirthPlace("my birth place");
		 priestBean.setMobileNo(987654321L);
		 priestBean.setTelephoneNo(987654321L);
		 priestBean.setEmailId("aa@bb.com");
		 
		 priestBean.setDiocese("diocese");
		 priestBean.setAdditionalPosition("no position");
		 priestBean.setAdditionalInfo("<P>Addditional Info</p>");
		 
		 user = new UserBean();
		 user.setId(1001);
		 user.setChurchId(1);
		 
		 fileBean = new FileBean();
		 fileBean.setFile(new File("H:/santhome/CSC_0454.jpg"));
		 fileBean.setFileName("CSC_0454.jpg");
		 fileBean.setFileType("jpg");
	}
	
	@Test
	public void testSavePriest() throws Exception {
		PriestBean pBean = service.savePriest(priestBean, user, fileBean);
		Assert.assertNotNull(pBean.getId());
	}
}
