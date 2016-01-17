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

public class CityTest {
	static Log log = LogFactory.getLog(CityTest.class);

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
	
			City c = em.find(City.class, 10);
			log.info("id = " + c.getId());
			log.info("name = " + c.getName());
			
	
			TypedQuery<City> q = em.createNamedQuery("City.findAll", City.class);
			List<City> list =  q.getResultList();
			
			list.forEach(new Consumer<City>() {
	
				@Override
				public void accept(City c) {
					log.info(c.getId() + " " + c.getName());
				}
				
			});
			
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
		
	}

}
