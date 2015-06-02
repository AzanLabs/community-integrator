package com.coop.parish.data.modal;

import java.util.List;
import java.util.concurrent.ThreadFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("thread interrupted");
			e.printStackTrace();
		}
		User user = new User();
		user.setIdentifier("hai");
		user.setPassword("admn");
		user.setType("b");
		em.persist(user);
		//em.getTransaction().commit();
		//em.close();
		//emf.close();
		
		EntityManager em1 = emf.createEntityManager();
		System.out.println("is joined to transaction" +em1.isJoinedToTransaction());
		System.out.println("is em open" +em1.isOpen());
		em1.joinTransaction();
		User usr1 = new User();
		usr1.setIdentifier("hai1");
		usr1.setPassword("admn1");
		usr1.setType("b");
		em1.persist(usr1);
		em1.getTransaction().commit();
		em1.close();
		
		
		System.out.println(em.isOpen());
		
	}

}
