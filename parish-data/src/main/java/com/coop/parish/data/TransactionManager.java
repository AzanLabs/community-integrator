package com.coop.parish.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * a singleton factory class which maintains the entity manager factory
 * 
 */
public class TransactionManager {
	//single emtity manager factory for the whole application
	private static EntityManagerFactory emf = null;
	
	private TransactionManager(){}
	
	//lazy loads the emf when needed, only one emf instanc is created for the whole application
	public static EntityManagerFactory getEMF(){
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("jpa-test");
		}
		return emf; 
	}
}
