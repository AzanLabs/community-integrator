package com.coop.parish.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TransactionManager {
	
	private static EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public TransactionManager(){
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("jpa-test");
			
		}
	}
	
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public void close(){
		if(em != null){
			em.flush();
			em.close();
		}
		if(emf != null){
			emf.close();
		}
	}
}
