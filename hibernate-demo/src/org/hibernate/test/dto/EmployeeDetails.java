package org.hibernate.test.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @Table's name attribute is the actual table name. 
 * @Entitiy's name is useful if you have two @Entity classes with the same name 
 * and you need a way to differentiate them when running queries.
 */
 
@Entity//(name = "EMPLOYEE_DETAILS")
@Table(name = "EMPLOYEE_DETAILS")
@NamedQuery(name = "employeeNameByCode", query = "select employeeName from EmployeeDetails where employeeCode = ?1")
@NamedNativeQuery(name = "employeeByName", query = "select * from EMPLOYEE_DETAILS where EMPLOYEE_NAME = :employeeName", resultClass = EmployeeDetails.class)
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;
	
	@Column(name = "EMPLOYEE_CODE")
	private String employeeCode;
	
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	
	/**
	 * Address is an embeddable object we can embed Address objects in this entity.
	 * This will appear as extra columns in the underlying table.
	 * If we have multiple same embeddable object instances in the same entity,
	 * then we need to specify the column names of fields of different instances separately.
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name = "HOME_STREET_NAME")),
		@AttributeOverride(name="city", column=@Column(name = "HOME_CITY_NAME")),
		@AttributeOverride(name="state", column=@Column(name = "HOME_STATE_NAME")),
		@AttributeOverride(name="pin", column=@Column(name = "HOME_PINCODE"))
	})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name = "OFFICE_STREET_NAME")),
		@AttributeOverride(name="city", column=@Column(name = "OFFICE_CITY_NAME")),
		@AttributeOverride(name="state", column=@Column(name = "OFFICE_STATE_NAME")),
		@AttributeOverride(name="pin", column=@Column(name = "OFFICE_PINCODE"))
	})
	private Address officeAddress;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ROLE") // Add this column to this table
	private EmployeeRole employeeRole;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TEAM_ID") // Add this column to this table
	private Team team;

	public EmployeeDetails() {
		super();
	}

	public EmployeeDetails(String employeeName) {
		super();
		this.employeeName = employeeName;
	}

	public EmployeeDetails(String employeeCode, String employeeName) {
		super();
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public EmployeeRole getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(EmployeeRole employeeRole) {
		this.employeeRole = employeeRole;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", employeeCode=" + employeeCode + ", employeeName="
				+ employeeName + "]";
	}


}
