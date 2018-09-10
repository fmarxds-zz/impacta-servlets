package com.everis.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaMySqlPU");
	
	public static EntityManager geEntityManager() {
		return emf.createEntityManager();
	}
	
}
