package org.springboot.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springboot.demo.model.dto.FeatureDTO;
import org.springboot.demo.model.entities.FeatureEntity;
import org.springboot.demo.model.mapper.FeatureMapper;
import org.springboot.demo.repository.FeatureRepository;
import org.springboot.demo.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureServiceImpl implements FeatureService {

	@Autowired
	private FeatureRepository featureRepo;
	@Autowired
	private FeatureMapper featureMapper;

//	public List<FeatureDTO> getAllFeatures() {
//		return featureRepo.getFeatures();
//	}
//
//	public FeatureDTO getFeatureById(int featureId) {
//		return featureRepo
//				.getFeatures()
//				.stream()
//				.filter(f->f.getFeatureId()==featureId)
//				.findFirst()
//				.get();
//	}
//
//	public FeatureDTO addFeature(String featureName) {
//		FeatureDTO feature = new FeatureDTO(featureName);
//		
//		return featureRepo.addFeature(feature);
//	}
//
//	public FeatureDTO updateFeature(int featureId, String featureName) {
//		FeatureDTO feature = getFeatureById(featureId);
//		feature.setFeatureName(featureName);
//		
//		return featureRepo.updateFeature(feature);
//	}
//
//	public String deleteFeature(int featureId) {
//		FeatureDTO feature = getFeatureById(featureId);
//		
//		if (feature == null)
//			return "Not found";
//
//		if (featureRepo.deleteFeature(feature))
//			return "Feature deleted";
//		else
//			return "Failed to delete feature";
//	}
	
	public List<FeatureDTO> getAllFeatures() {
		List<FeatureDTO> features = new ArrayList<FeatureDTO>();
		
		featureRepo.findAll().forEach(f-> features.add(featureMapper.mapFeatureEntityToDTO(f)));
		
		return features;
	}

	public FeatureDTO getFeatureById(int featureId) {
		return featureMapper.mapFeatureEntityToDTO(featureRepo.findById(featureId).get());
	}

	public FeatureDTO addFeature(FeatureDTO feature) {
		return featureMapper.mapFeatureEntityToDTO(
				featureRepo.save(
						featureMapper.mapFeatureDTOToEntity(feature)));
	}

	public FeatureDTO updateFeature(int featureId, FeatureDTO feature) {
		return featureMapper.mapFeatureEntityToDTO(
				featureRepo.save(
						featureMapper.mapFeatureDTOToEntity(feature)));
	}

	public String deleteFeature(int featureId) {
		FeatureEntity featureEntity = featureRepo.findById(featureId).get();
		
		if (featureEntity == null)
			return "Not found";
		
		featureRepo.deleteById(featureId);
		
		return "Feature deleted";
	}

}
