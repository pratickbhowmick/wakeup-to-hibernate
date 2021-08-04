package org.hibernate.test.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("UTILITY")
public class UtilityService extends Service {
	
	@Column(name = "UTILITY_CLASS")
	private String utility;

	public UtilityService(String serviceName, String utility) {
		super(serviceName);
		this.utility = utility;
	}

	public String getUtility() {
		return utility;
	}

	public void setUtility(String utility) {
		this.utility = utility;
	}

}
