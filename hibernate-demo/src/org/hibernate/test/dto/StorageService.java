package org.hibernate.test.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("STORAGE")
public class StorageService extends Service {

	@Column(name = "STORAGE_TYPE")
	private String storageType;

	@Column(name = "STORAGE_ACTION")
	private String action;

	public StorageService(String serviceName, String storageType, String action) {
		super(serviceName);
		this.storageType = storageType;
		this.action = action;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
