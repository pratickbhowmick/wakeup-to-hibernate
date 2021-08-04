package org.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.test.dto.BusinessService;
import org.hibernate.test.dto.Service;
import org.hibernate.test.dto.StorageService;
import org.hibernate.test.dto.UtilityService;

public class InheritenceDemo {

	public static void main(String[] args) {
		Service serviceA = new Service("Service A");
		BusinessService businessService = new BusinessService("Service A Business Process", "Business Domain A");
		StorageService storageService = new StorageService("Service A Persistence", "Cloud Storage", "Update");
		UtilityService utilityService = new UtilityService("Service A Logging", "Logging");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		session.save(serviceA);
		session.save(businessService);
		session.save(storageService);
		session.save(utilityService);
		
		txn.commit();
		txn = null;
		session.close();
	}

}
