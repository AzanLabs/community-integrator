package com.coop.parish.data.modal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		User user = new User();
		user.setIdentifier("hai1");
		user.setPassword("admn1");
		user.setType("b");
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
