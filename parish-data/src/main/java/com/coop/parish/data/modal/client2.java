package com.coop.parish.data.modal;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
			
		em.getTransaction().commit();
		em.clear();
		em.close();
		factory.close();
	}

}
