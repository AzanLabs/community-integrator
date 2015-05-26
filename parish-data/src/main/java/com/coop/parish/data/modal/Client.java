package com.coop.parish.data.modal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User usr = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			usr = new User();
			String queryStmt = "select usr from User as usr";
			Query query = em.createQuery(queryStmt);
			List<User> users = query.getResultList();
			System.out.println("users "+users.get(0).getIdentifier());
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		System.out.println("user "+usr.getId());
	}

}
