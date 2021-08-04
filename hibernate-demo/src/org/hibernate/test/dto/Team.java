package org.hibernate.test.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEAM_ID")
	private int teamId;
	
	@Column(name = "TEAM_NAME")
	private String teamName;
	
	@OneToMany(mappedBy = "team", fetch = FetchType.EAGER) // mappedBy = "teams" marks this collection item to be mapped to EmployeeDetails.teams
//	@JoinTable( // JoinTable, GenericGenerator, CollectionId are for a separate join table
//		name = "TEAM_EMPLOYEES", // Join Table name
//		joinColumns = @JoinColumn(name = "TEAM_ID"), // Column from this table
//		inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID") // Column from referencing table
//	)
//	@GenericGenerator(name = "incrementGenerator", strategy = "increment") // Generator
//	@CollectionId(
//			columns = @Column(name = "TEAM_EMPLOYEE_ID"),
//			generator = "incrementGenerator",
//			type = @Type(type = "long")
//	)
	private List<EmployeeDetails> employees;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UNIT_ID")
	private OrganisationUnit unit;
	
	public Team() {}

	public Team(String teamName) {
		super();
		this.teamName = teamName;
		this.employees = new ArrayList<EmployeeDetails>();
	}

	public int getTeamId() {
		return teamId;
	}
	
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public List<EmployeeDetails> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<EmployeeDetails> employees) {
		this.employees = employees;
	}

	public OrganisationUnit getUnit() {
		return unit;
	}

	public void setUnit(OrganisationUnit unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", employees=" + employees.size() + ", unit=" + unit
				+ "]";
	}

}
