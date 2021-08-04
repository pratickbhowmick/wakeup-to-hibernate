package org.springboot.demo.model.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FeatureDTO implements Serializable{
	
	private int featureId;
	private String featureName;
	
	public FeatureDTO(String featureName) {
		super();
		this.featureName = featureName;
	}

	public FeatureDTO(int featureId, String featureName) {
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
