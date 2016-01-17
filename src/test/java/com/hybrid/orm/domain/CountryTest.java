package com.hybrid.orm.domain;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hybrid.orm.domain.City;
import com.hybrid.orm.domain.Country;

public class CountryTest {
	static Log log = LogFactory.getLog(CountryTest.class);

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();

		Country c = em.find(Country.class, "KOR");
		log.info("id = " + c.getCode());
		log.info("name = " + c.getName());
		

		TypedQuery<Country> q = em.createNamedQuery("Country.findAll", Country.class);
		List<Country> list =  q.getResultList();
		
//		list.forEach(new Consumer<Country>() {
//
//			@Override
//			public void accept(Country c) {
//				log.info(c.getCode() + " " + c.getName());
//			}
//			
//		});
		
		et.commit();
		
		em.close();
		emf.close();
		
	}

}
