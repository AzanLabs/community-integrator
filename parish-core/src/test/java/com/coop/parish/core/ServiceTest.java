package com.coop.parish.core;

import java.util.Date;

import com.coop.parish.core.beans.ChurchBean;
import com.coop.parish.core.beans.EChurchBean;
import com.coop.parish.core.beans.EventBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.ChurchService;
import com.coop.parish.core.service.EventService;
import com.coop.parish.data.modal.Church;
import com.coop.parish.data.modal.ChurchAdditionalInfo;

public class ServiceTest {

	public static void main(String[] args) throws InterruptedException {
		ServiceTest test = new ServiceTest();
		test.saveChurch();
		//test.getChurch();
		//test.updateChurch();
		//test.deleteChurch();
		
		//test.saveEvent();
	}
	
	public void saveChurch(){
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
		ChurchService service = ServiceLocator.instance().getChurchService();
		try {
			churchBean = service.saveChurch(churchBean);
		} catch (Exception e) {
			System.out.println("exception catched");
			e.printStackTrace();
		}
		System.out.println("is church bean saved "+(churchBean.getId() > 0));
	}
	
	public void updateChurch(){
		ChurchBean bean = new ChurchBean();
		bean.setId(1);
		bean.setName("mycoop");
		ChurchService service = ServiceLocator.instance().getChurchService();
		try {
			service.updateChurch(bean);
		} catch (Exception e) {
			System.out.println("exception catched");
			e.printStackTrace();
		}
		//System.out.println("is church bean saved "+(bean.getName()));
	}
	public void saveEvent(){
		EventBean bean  = new EventBean();
		bean.setName("new yr prayer");
		bean.setEventDate(new Date());
		bean.setDescription("prayer");
		bean.setDetails("long event desc....");
		bean.setChurchId(1);
		
		EventService service = ServiceLocator.instance().getEventService();
		try {
			bean = service.saveEvent(bean);
		} catch (Exception e) {
			System.out.println("exception catched");
			e.printStackTrace();
		}
		System.out.println("is event saved "+(bean.getId() > 0));
	}
	
	public void getChurch(){
		ChurchService service = ServiceLocator.instance().getChurchService();
		ChurchBean bean = null;
		try {
			bean = service.getChurchById(1);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//System.out.println("church priest " +bean.getEvents());
	}
	
	public void deleteChurch(){
		ChurchService service = ServiceLocator.instance().getChurchService();
		try {
			service.deleteChurch(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
