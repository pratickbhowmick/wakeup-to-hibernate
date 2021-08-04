package org.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.test.dto.Service;

public class HQLDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		for (int i = 0; i < 10; i++) {
			Service service = new Service("Service"+i);
			session.save(service);
		}
		
		txn.commit();
		session.close();
		txn = null;
		
		String minServiceId = "5";
		session = sessionFactory.openSession();
		
//		Query query = session.createQuery("from Service");
//		query.setFetchSize(3);
//		query.setFirstResult(2); // Start from given row number
//		query.setMaxResults(6); // Max num of rows
//		Query query = session.createQuery("from Service where serviceId > 5");
//		Query query = session.createQuery("select serviceName from Service");
/*		Query query = session.createQuery("select serviceName from Service where serviceId > ?1");
		query.setParameter(1, Integer.parseInt(minServiceId)); */
		Query query = session.createQuery("select serviceName from Service where serviceId > :minServiceId");
		query.setParameter("minServiceId", Integer.parseInt(minServiceId));
		
		List<String> list = query.list();
		
		session.close();
		
		list.stream().forEach(s -> System.out.println(s));
	}

}
