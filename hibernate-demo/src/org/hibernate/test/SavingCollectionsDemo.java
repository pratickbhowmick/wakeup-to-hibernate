package org.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.test.dto.Project;
import org.hibernate.test.dto.OrganisationUnit;

public class SavingCollectionsDemo {

	
	public static void main(String[] args) {
		List<Project> projects = new ArrayList<Project>();
		projects.add(new Project("First Project", 100000000));
		projects.add(new Project("Second Project", 150000000));
		projects.add(new Project("Third Project", 20000000));
		OrganisationUnit unit = new OrganisationUnit("Unit One");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(unit);
		txn.commit();
		session.close();
		
		session = sessionFactory.openSession();
		OrganisationUnit unit2 = session.get(OrganisationUnit.class, 1);
		
		System.out.println(unit2);
		unit2.getProjects().stream().forEach(u->System.out.println(u));
		session.close();
	}

}
