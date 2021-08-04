package org.springboot.demo.service;

import java.util.List;

import org.springboot.demo.model.dto.FeatureDTO;

public interface FeatureService {
	public List<FeatureDTO> getAllFeatures();
	public FeatureDTO getFeatureById(int featureId);
	public FeatureDTO addFeature(FeatureDTO feature);
	public FeatureDTO updateFeature(int featureId, FeatureDTO feature);
	public String deleteFeature(int featureId);
}
