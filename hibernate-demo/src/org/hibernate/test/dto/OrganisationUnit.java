package org.hibernate.test.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "ORGANISATION_UNIT")
public class OrganisationUnit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UNIT_ID")
	private int unitId;
	
	@Column(name = "UNIT_NAME")
	private String unitName;
	
	@ElementCollection(fetch = FetchType.EAGER) // To tell hibernate about the embedded list item
	@JoinTable(name = "PROJECT", joinColumns = @JoinColumn(name = "UNIT_ID")) // Add new join table=PROJECT, join column=UNIT_ID
//	@GenericGenerator(name = "incrementGenerator", strategy = "sequence") // Generator
	@GeneratedValue(generator = "hibernate_sequence", strategy = GenerationType.AUTO)
	@CollectionId(
			columns = @Column(name = "PROJECT_ID"),
			generator = "hibernate_sequence",
			type = @Type(type = "long")
	) // To declare PK for PROJECT table
	private List<Project> projects;

	public OrganisationUnit() {}

	public OrganisationUnit(String unitName) {
		super();
		this.unitName = unitName;
		this.projects = new ArrayList<Project>();
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		if (this.projects == null) {
			this.projects = new ArrayList<Project>();
		}
		
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "OrganisationUnit [unitId=" + unitId + ", unitName=" + unitName + ", projects=" + projects.size() + "]";
	}

}
