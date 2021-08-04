package org.hibernate.test.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class Project {
	
	@Column(name = "PROJECT_NAME")
	private String projectName;
	
	@Column(name = "PROJECT_PROFIT")
	private double projectEarnings;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public Project() {}

	public Project(String projectName, double projectEarnings) {
		super();
		this.projectName = projectName;
		this.projectEarnings = projectEarnings;
	}

	public Project(String projectName, double projectEarnings, Team team) {
		super();
		this.projectName = projectName;
		this.projectEarnings = projectEarnings;
		this.team = team;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public double getProjectEarnings() {
		return projectEarnings;
	}

	public void setProjectEarnings(double projectEarnings) {
		this.projectEarnings = projectEarnings;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", projectEarnings=" + projectEarnings + ", team=" + team + "]";
	}

}
