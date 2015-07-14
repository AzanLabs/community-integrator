package com.coop.parish.data;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.coop.parish.data.modal.Audit;
import com.coop.parish.data.modal.User;

public class ModalTest {
	
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	
	@BeforeClass
	public static void init(){
		ModalTest.emf = Persistence.createEntityManagerFactory("jpa-test");
		ModalTest.em = ModalTest.emf.createEntityManager();
		ModalTest.em.getTransaction().begin();
	}
	
	@Test
	public void insertUser(){
		User user = new User();
		user.setIdentifier("sadmin");
		user.setPassword("admin");
		user.setType("P");
		user.setChurchIsSet(false);
		user.setActive(true);
		
		Audit audit = new Audit();
		audit.setCreatedBy(1);
		audit.setCreatedOn(new Date());
		audit.setLastModifiedBy(1);
		audit.setLastModifiedOn(new Date());
		user.setAudit(audit);
		
		em.persist(user);
		System.out.println(user.getId());
	}
	
	@AfterClass
	public static void destroy(){
		ModalTest.em.getTransaction().commit();
		ModalTest.em.close();
		ModalTest.emf.close();
	}
}
