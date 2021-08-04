package org.hibernate.test.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FEATURE")
public class Feature {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FEATURE_ID")
	private int featureId;
	
	@Column(name = "FEATURE_NAME")
	private String featureName;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) // Cascade the persist effect to related object
	@JoinTable(
			name = "FEATURE_SERVICES",
			joinColumns = @JoinColumn(name = "FEATURE_ID"),
			inverseJoinColumns = @JoinColumn(name = "SERVICE_ID")
	)
	private List<Service> services;

	public Feature() {}

	public Feature(String featureName) {
		super();
		this.featureName = featureName;
		this.services = new ArrayList<Service>();
	}

	public int getFeatureId() {
		return featureId;
	}

	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Feature [featureId=" + featureId + ", featureName=" + featureName + ", services=" + services + "]";
	}
 	
}
