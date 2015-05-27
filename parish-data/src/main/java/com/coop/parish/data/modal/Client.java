package com.coop.parish.data.modal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			
		Address address = new Address();
		address.setDoorNo("320/218");
		address.setStreet("keelapalayam st");
		address.setTown("tenkasi");
		address.setTaluk("tenkasi");
		address.setDistrict("tirunelveli");
		address.setState("tn");
		address.setCountry("india");
		address.setPincode(627813);
		
		Church church = new Church();
		church.setName("coop");
		church.setAddress(address);
		church.setLandlineNo(new Long(98765432));
		church.setMobileNo(new Long(1234567890));
		church.setDiocese("dio");
		church.setEmailId("aaa.bbb.com");
		
		em.persist(church);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		System.out.println("user "+church.getId());
	}

}
