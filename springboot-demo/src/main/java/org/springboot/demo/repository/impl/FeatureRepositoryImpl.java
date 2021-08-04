package org.springboot.demo.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springboot.demo.model.dto.FeatureDTO;
import org.springboot.demo.repository.FeatureRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FeatureRepositoryImpl /* implements FeatureRepository */  {
	
	private List<FeatureDTO> features;
	
	public FeatureRepositoryImpl() {
		features = new ArrayList<FeatureDTO>(Arrays.asList(
				new FeatureDTO(1, "Feature A"),
				new FeatureDTO(2, "Feature B"),
				new FeatureDTO(3, "Feature C"),
				new FeatureDTO(4, "Feature D")
				));
	}

	public List<FeatureDTO> getFeatures() {
		return features;
	}

	public FeatureDTO addFeature(FeatureDTO feature) {
		feature.setFeatureId(getMaxFeatureIdInList()+1);
		features.add(feature);
		
		return feature;
	}

	public FeatureDTO updateFeature(FeatureDTO feature) {
		return features.set(getFeatureIndex(feature), feature);
	}

	public boolean deleteFeature(FeatureDTO feature) {
		return features.remove(feature);
	}
	
	private int getMaxFeatureIdInList() {
		return features.get(features.size()-1).getFeatureId();
	}
	
	private int getFeatureIndex(FeatureDTO feature) {
		return features.indexOf(feature);
	}
	
}
