package org.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.test.dto.Service;

public class CRUDDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
//		CREATE
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		for (int i = 0; i < 10; i++) {
			Service service = new Service("Service"+i);
			session.save(service);
		}
		
		txn.commit();
		txn = null;
		
//		READ
		Service service = session.get(Service.class, 3);
		System.out.println(service.getServiceName());
		
//		UPDATE
		service = session.get(Service.class, 4);
		service.setServiceName("Service3 Updated");
		
		txn = session.beginTransaction();
		session.update(service);
		txn.commit();
		txn = null;
		
		service = session.get(Service.class, 4);
		System.out.println(service.getServiceName());
		
//		DELETE
		service = session.get(Service.class, 6);
		
		txn = session.beginTransaction();
		session.delete(service);
		txn.commit();
		txn = null;
	}

}
