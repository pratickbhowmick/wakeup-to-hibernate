package org.hibernate.test.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "SERVICE")
/**
 * Inheritence strategy defines whether the child class will be stored in a single table or separate table or be linked
 * to the parent table. If single table strategy is not used there will be no dtype column.
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "SERVICE_TYPE") // Name for dtype column
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SERVICE_ID")
	private int serviceId;

	@Column(name = "SERVICE_NAME")
	private String serviceName;

	@ManyToMany(mappedBy = "services", fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE) // Ignore if not found
	private List<Feature> features;

	public Service() {}

	public Service(String serviceName) {
		super();
		this.serviceName = serviceName;
		this.features = new ArrayList<Feature>();
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceName=" + serviceName + ", features=" + features.size() + "]";
	}
	
}
