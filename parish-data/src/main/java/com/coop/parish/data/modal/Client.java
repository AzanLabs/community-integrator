package com.coop.parish.data.modal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User usr = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		for(int i = 0 ; i < 100; i++){
			usr = new User();
			usr.setName("sankar");
			usr.setPwd("admin");
			em.persist(usr);
			if(i % 50 == 0){
				em.flush();
				em.clear();
			}
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		System.out.println("user "+usr.getId());
	}

}
