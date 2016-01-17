package com.hybrid.orm.employee;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.dialect.Oracle10gDialect;

import com.hybrid.orm.domain.City;
import com.hybrid.orm.domain.Country;
import com.hybrid.orm.domain.Dept;

public class DeptTest {
	static Log log = LogFactory.getLog(DeptTest.class);

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
	
			Dept d = em.find(Dept.class, 10L);
			log.info("deptno = " + d.getDeptno());
			log.info("name = " + d.getDname());
			
	
			TypedQuery<Dept> q = em.createNamedQuery("Dept.findAll", Dept.class);
			List<Dept> list =  q.getResultList();
			
			list.forEach(new Consumer<Dept>() {
	
				@Override
				public void accept(Dept d) {
					log.info(d.getDeptno() + " " + d.getDname());
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
