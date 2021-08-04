package org.springboot.demo.repository;

import java.util.List;

import org.springboot.demo.model.dto.FeatureDTO;
import org.springboot.demo.model.entities.FeatureEntity;
import org.springframework.data.repository.CrudRepository;

public interface FeatureRepository  extends CrudRepository<FeatureEntity, Integer>  {
//	public List<FeatureDTO> getFeatures();
//	public FeatureDTO addFeature(FeatureDTO feature);
//	public FeatureDTO updateFeature(FeatureDTO feature);
//	public boolean deleteFeature(FeatureDTO feature);
}
