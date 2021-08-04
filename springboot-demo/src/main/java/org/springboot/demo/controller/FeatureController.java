package org.springboot.demo.controller;

import java.util.List;

import org.springboot.demo.model.dto.FeatureDTO;
import org.springboot.demo.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/features")
public class FeatureController {
	
	@Autowired
	private FeatureService featureService;
	
	@RequestMapping("/all")
	public List<FeatureDTO> getFeatures() {
		return featureService.getAllFeatures();
	}

	@RequestMapping("/{featureId}")
	public FeatureDTO getFeatureById(@PathVariable int featureId) {
		return featureService.getFeatureById(featureId);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public FeatureDTO addFeature(@RequestBody FeatureDTO feature) {
		return featureService.addFeature(feature);
	}
	
	@RequestMapping(value = "/{featureId}", method = RequestMethod.PUT)
	public FeatureDTO updateFeature(@PathVariable int featureId, @RequestBody FeatureDTO feature) {
		return featureService.updateFeature(featureId, feature);
	}
	
	@RequestMapping(value = "/{featureId}", method = RequestMethod.DELETE)
	public String deleteFeature(@PathVariable int featureId) {
		return featureService.deleteFeature(featureId);
	}
	
}
