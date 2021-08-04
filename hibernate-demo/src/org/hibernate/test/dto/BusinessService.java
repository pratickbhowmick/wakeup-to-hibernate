package org.hibernate.test.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BUSINESS") // Provides value for the discriminator column
public class BusinessService extends Service {

	@Column(name = "BUSINESS_DOMAIN")
	private String domain;

	public BusinessService(String serviceName, String domain) {
		super(serviceName);
		this.domain = domain;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
