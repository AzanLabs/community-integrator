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
		
		
		//em.persist();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		
	}

}
