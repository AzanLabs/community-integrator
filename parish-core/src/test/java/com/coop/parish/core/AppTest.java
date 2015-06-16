package com.coop.parish.core;

import com.coop.parish.core.beans.ChurchBean;
import com.coop.parish.core.service.ChurchService;
import com.coop.parish.data.modal.Church;
import com.coop.parish.data.modal.ChurchAdditionalInfo;

public class AppTest{
	
	public static void main(String[] args){
		ChurchService service = ServiceLocator.instance().getChurchService();
		
		Church church = new Church();
		church.setName("coop");
		
		church.setDoorNo("door");
		church.setStreet("street");
		church.setVillage("myt villa");
		church.setTaluk("my taluk");
		church.setDistrict("dis");
		church.setState("tn");
		church.setCountry("in");
		church.setPincode(1234);
		
		church.setTelephoneNo(123456L);
		church.setMobileNo(12345L);
		church.setEmailId("aaa@yyy.com");
		church.setDiocese("dio");
		
		ChurchAdditionalInfo churchInfo = new ChurchAdditionalInfo();
		churchInfo.setInfo("<p>My Church</p>");
		church.setAdditionalInfo(churchInfo);
		
		ChurchBean churchBean = new ChurchBean(church);
		try {
			//churchBean = service.saveChurch(churchBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*service = ServiceLocator.instance().getChurchService();
		int id = 0;
		try {
			id = service.deleteChurch(6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(churchBean.getId());
		System.out.println(String.valueOf(id));*/
	}
}