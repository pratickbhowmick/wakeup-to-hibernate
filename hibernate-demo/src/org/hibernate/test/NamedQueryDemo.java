package org.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.test.dto.EmployeeDetails;

public class NamedQueryDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		int index = 0;

		for (int i = 101; i <= 120; i++) {
			EmployeeDetails emp = new EmployeeDetails(i+"", "Employee Name"+ ++index);
			session.save(emp);
		}
		
		txn.commit();
		session.close();
		txn = null;
		
		session = sessionFactory.openSession();
		Query query = session.getNamedQuery("employeeNameByCode");
		query.setParameter(1, "105");
		
		List<String> list = query.list();
		
		session.close();
		
		list.stream().forEach(s -> System.out.println(s));
		
		session = sessionFactory.openSession();
		query = session.getNamedNativeQuery("employeeByName");
		query.setParameter("employeeName", "Employee Name5");
		
		EmployeeDetails emp = (EmployeeDetails) query.uniqueResult();
		
		session.close();
		
		System.out.println(emp);
	}

}
