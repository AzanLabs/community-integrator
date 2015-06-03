package com.coop.parish.data.modal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Church church = new Church();
		church.setId(1);
		church.setName("coop");
		
		church.setDoorNo("door");
		church.setStreet("street");
		church.setVillage("myt villa");
		church.setTaluk("my taluk1");
		church.setDistrict("dis");
		church.setState("tn12");
		church.setCountry("in");
		church.setPincode(1234);
		
		church.setTelephoneNo(123456L);
		church.setMobileNo(12345L);
		church.setEmailId("aaa@yyy.coms");
		church.setDiocese("dio");
		
		ChurchAdditionalInfo churchInfo = new ChurchAdditionalInfo();
		churchInfo.setInfo("<p>My Church</p>");
		
		church.setAdditionalInfo(churchInfo);
		//em.persist(church);
		/*Query query = em.createQuery("select c from ChurchInfo as c where c.id = 1");
		Church church = (Church) query.getSingleResult();
		System.out.println("church name is "+church.getName());
		System.out.println("after");*/
		//em.merge(church);
		em.getTransaction().commit();
		em.close();
		emf.close();		
		
	}

}
