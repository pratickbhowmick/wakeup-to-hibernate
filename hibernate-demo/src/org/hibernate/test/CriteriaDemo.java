package org.hibernate.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.test.dto.EmployeeDetails;

public class CriteriaDemo {

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
		Criteria criteria = session.createCriteria(EmployeeDetails.class);
		criteria.add(Restrictions.eq("employeeName", "Employee Name5"));
		EmployeeDetails emp = (EmployeeDetails) criteria.uniqueResult();
		System.out.println(emp);
	}

}
