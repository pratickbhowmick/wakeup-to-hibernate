package org.hibernate.test.dto;

import javax.persistence.Embeddable;

@Embeddable // Indicates this object can be embedded in an entity
public class Address {
	
	private String street;
	private String city;
	private String state;
	private String pin;
	
	public Address() {}

	public Address(String street, String city, String state, String pin) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", pin=" + pin + "]";
	}
	
}
