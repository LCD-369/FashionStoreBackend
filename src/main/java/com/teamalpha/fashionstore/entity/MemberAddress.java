package com.teamalpha.fashionstore.entity;

import java.io.Serializable;

public class MemberAddress implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String streetAddress;
	private String city;
	private String zipcode;
	private String state;
	private String country;
	
	public MemberAddress() {
		
	}

	public MemberAddress(String streetAddress, String city, String zipcode, String state, String country) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.country = country;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
