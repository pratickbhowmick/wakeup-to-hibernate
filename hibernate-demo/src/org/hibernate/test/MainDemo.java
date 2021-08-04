package org.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.test.dto.Address;
import org.hibernate.test.dto.EmployeeDetails;
import org.hibernate.test.dto.EmployeeRole;

public class MainDemo {

	
	public static void main(String[] args) {
		EmployeeDetails employee = new EmployeeDetails("Employee One");
		employee.setEmployeeId(1);
		employee.setHomeAddress(new Address("Home Street Name", "Home City Name", "Home State Name", "123456"));
		employee.setOfficeAddress(new Address("Office Street Name", "Office City Name", "Office State Name", "456789"));
		
		EmployeeRole role = new EmployeeRole("Staff Software Engineer");
		employee.setEmployeeRole(role);
		
		/**
		 * The Configuration object is the first Hibernate object you create in any Hibernate application. 
		 * It is usually created only once during application initialization.
		 * It represents a configuration or properties file required by the Hibernate.
		 * The Configuration object provides two keys components −
		 * 		1. Database Connection − This is handled through one or more configuration files supported by Hibernate. 
		 * 							  	 These files are hibernate.properties and hibernate.cfg.xml.
		 * 		2. Class Mapping Setup − This component creates the connection between the Java classes and database tables. 
		 * 		
		 * Configuration object is used to create a SessionFactory object which in turn configures Hibernate for the 
		 * application using the supplied configuration file and allows for a Session object to be instantiated.
		 * The SessionFactory is a thread safe object and used by all the threads of an application.
		 * 
		 * The SessionFactory is a heavyweight object; it is created during application start up and kept for later use. 
		 * You would need one SessionFactory object per database using a separate configuration file. 
		 * So, if you are using multiple databases, then you would have to create multiple SessionFactory objects.
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		/**
		 * A Session is used to get a physical connection with a database. The Session object is lightweight 
		 * and designed to be instantiated each time an interaction is needed with the database. Persistent objects are saved 
		 * and retrieved through a Session object.
		 * 
		 * The session objects should not be kept open for a long time because they are not usually thread safe 
		 * and they should be created and destroyed them as needed.		
		 */
		Session session = sessionFactory.openSession();
		
		/**
		 * A Transaction represents a unit of work with the database and most of the RDBMS supports transaction functionality. 
		 * Transactions in Hibernate are handled by an underlying transaction manager and transaction (from JDBC or JTA).
		 * 
		 * This is an optional object and Hibernate applications may choose not to use this interface, 
		 * instead managing transactions in their own application code.
		 */
		Transaction txn = session.beginTransaction();
		session.save(employee);
		session.save(role);
		txn.commit();
		txn = null;
		session.close();
		employee = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		employee = session.get(EmployeeDetails.class, 1);
		System.out.println(employee);
		session.close();
	}

}
