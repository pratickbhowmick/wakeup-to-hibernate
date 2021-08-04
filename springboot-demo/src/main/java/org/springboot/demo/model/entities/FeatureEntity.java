package org.springboot.demo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FEATURE")
public class FeatureEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FEATURE_ID")
	private int featureId;
	@Column(name = "FEATURE_NAME")
	private String featureName;
	
	public FeatureEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeatureEntity(String featureName) {
		super();
		this.featureName = featureName;
	}

	public FeatureEntity(int featureId, String featureName) {
		super();
		this.featureId = featureId;
		this.featureName = featureName;
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
	
}
