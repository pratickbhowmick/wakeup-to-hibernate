package org.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.test.dto.EmployeeDetails;
import org.hibernate.test.dto.EmployeeRole;
import org.hibernate.test.dto.Feature;
import org.hibernate.test.dto.OrganisationUnit;
import org.hibernate.test.dto.Project;
import org.hibernate.test.dto.Service;
import org.hibernate.test.dto.Team;

public class MappingDemo {
	
	public static void main(String[] args) {
		OrganisationUnit unit = new OrganisationUnit("Unit One");
		
		Team teamA = new Team("Team A");
		teamA.setUnit(unit);
		Team teamB = new Team("Team B");
		teamB.setUnit(unit);
		
		EmployeeRole staffSERole = new EmployeeRole("Staff Software Engineer");
		EmployeeRole sseRole = new EmployeeRole("Senior Software Engineer");
		EmployeeRole se2Role = new EmployeeRole("Software Engineer 2");
		EmployeeRole seRole = new EmployeeRole("Software Engineer");
		
		EmployeeDetails employee1 = new EmployeeDetails("Employee One");
		employee1.setEmployeeRole(staffSERole);
		employee1.setTeam(teamA);
		EmployeeDetails employee2 = new EmployeeDetails("Employee Two");
		employee2.setEmployeeRole(sseRole);
		employee2.setTeam(teamA);
		EmployeeDetails employee3 = new EmployeeDetails("Employee Three");
		employee3.setEmployeeRole(se2Role);
		employee3.setTeam(teamA);
		EmployeeDetails employee4 = new EmployeeDetails("Employee Four");
		employee4.setEmployeeRole(seRole);
		employee4.setTeam(teamA);
		EmployeeDetails employee5 = new EmployeeDetails("Employee Five");
		employee5.setEmployeeRole(seRole);
		employee5.setTeam(teamA);
		EmployeeDetails employee6 = new EmployeeDetails("Employee Six");
		employee6.setEmployeeRole(staffSERole);
		employee6.setTeam(teamB);
		EmployeeDetails employee7 = new EmployeeDetails("Employee Seven");
		employee7.setEmployeeRole(sseRole);
		employee7.setTeam(teamB);
		EmployeeDetails employee8 = new EmployeeDetails("Employee Eight");
		employee8.setEmployeeRole(se2Role);
		employee8.setTeam(teamB);
		EmployeeDetails employee9 = new EmployeeDetails("Employee Nine");
		employee9.setEmployeeRole(seRole);
		employee9.setTeam(teamB);
		EmployeeDetails employee10 = new EmployeeDetails("Employee Ten");
		employee10.setEmployeeRole(seRole);
		employee10.setTeam(teamB);
		
		Project project1 = new Project("First Project", 100000000, teamA);
		Project project2 = new Project("Second Project", 150000000, teamB);
		
		unit.getProjects().add(project1);
		unit.getProjects().add(project2);
		
		Feature featureA = new Feature("Feature A");
		Feature featureB = new Feature("Feature B");
		Feature featureC = new Feature("Feature C");
		Feature featureD = new Feature("Feature D");
		
		Service serviceA = new Service("Service A");
		Service serviceB = new Service("Service B");
		Service serviceC = new Service("Service C");
		Service serviceD = new Service("Service D");
		
		List<Service> services = new ArrayList<Service>();
		services.add(serviceA);
		services.add(serviceB);
		services.add(serviceC);
		services.add(serviceD);
		
		featureA.setServices(services);
		featureB.setServices(services);
		featureC.setServices(services);
		featureD.setServices(services);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		session.save(unit);
		
		session.save(teamA);
		session.save(teamB);
		
		session.save(staffSERole);
		session.save(sseRole);
		session.save(se2Role);
		session.save(seRole);
		
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(employee4);
		session.save(employee5);
		session.save(employee6);
		session.save(employee7);
		session.save(employee8);
		session.save(employee9);
		session.save(employee10);
		
		session.persist(featureA); // This ties in with the cascading persist 
		session.persist(featureB);
		session.persist(featureC);
		session.persist(featureD);
		
		txn.commit();
		txn = null;
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		unit = session.get(OrganisationUnit.class, 1);
		session.close();
		
		System.out.println(unit);
	}
	
}
