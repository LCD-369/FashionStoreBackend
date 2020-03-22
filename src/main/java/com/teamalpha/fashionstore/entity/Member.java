package com.teamalpha.fashionstore.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "FashionrusStore")
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pk;
	private String sk;
	private String username;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String addressStreet;
	private String city;
	private String zipcode;
	private String state;
	private String country;

	public Member() {

	}

	public Member(String pk, String sk, String username, String email, String password, String firstName,
			String lastName, String phone, String addressStreet, String city, String zipcode, String state, String country) {

		this.pk = pk;
		this.sk = sk;
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.addressStreet = addressStreet;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.country = country;
	}

	@DynamoDBHashKey(attributeName = "PK")
	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	@DynamoDBRangeKey(attributeName = "SK")
	public String getSk() {
		return sk;
	}

	public void setSk(String sk) {
		this.sk = sk;
	}

	@DynamoDBAttribute(attributeName = "USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@DynamoDBAttribute(attributeName = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@DynamoDBAttribute(attributeName = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@DynamoDBAttribute(attributeName = "FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@DynamoDBAttribute(attributeName = "LASTNAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DynamoDBAttribute(attributeName = "PHONE")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@DynamoDBAttribute(attributeName = "ADDRESSSTREET")
	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	@DynamoDBAttribute(attributeName = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@DynamoDBAttribute(attributeName = "ZIPCODE")
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@DynamoDBAttribute(attributeName = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@DynamoDBAttribute(attributeName = "COUNTRY")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Member [pk=" + pk + ", sk=" + sk + ", username=" + username + ", email=" + email + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", addressStreet=" + addressStreet + ", city=" + city + ", zipcode=" + zipcode + ", state=" + state
				+ ", country=" + country + "]";
	}

}
