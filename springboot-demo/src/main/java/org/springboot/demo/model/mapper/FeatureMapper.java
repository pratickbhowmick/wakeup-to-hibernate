package org.springboot.demo.model.mapper;

import org.springboot.demo.model.dto.FeatureDTO;
import org.springboot.demo.model.entities.FeatureEntity;
import org.springframework.stereotype.Component;

@Component
public class FeatureMapper {
	
	public FeatureDTO mapFeatureEntityToDTO(FeatureEntity from) {
		return new FeatureDTO(from.getFeatureId(), from.getFeatureName());
	}
	
	public FeatureEntity mapFeatureDTOToEntity(FeatureDTO from) {
		return new FeatureEntity(from.getFeatureId(), from.getFeatureName());
	}

}
