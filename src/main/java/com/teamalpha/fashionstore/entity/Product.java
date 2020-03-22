package com.teamalpha.fashionstore.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "FashionrusStore")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pk;
	private String sk;
	private String data;
	private String size;
	private String productId;
	private String color;
	private int year;
	private double price;
	private String gender;
	private int quantity;
	private String type;

	public Product() {
	}

	public Product(String pk, String sk, String data, String size, String productId, String color, int year,
			double price, String gender, int quantity, String type) {
		this.pk = pk;
		this.sk = sk;
		this.data = data;
		this.size = size;
		this.productId = productId;
		this.color = color;
		this.year = year;
		this.price = price;
		this.gender = gender;
		this.quantity = quantity;
		this.type = type;
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

	public void setSK(String sk) {
		this.sk = sk;
	}

	@DynamoDBAttribute(attributeName = "DATA")
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@DynamoDBAttribute(attributeName = "SIZE")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@DynamoDBAttribute(attributeName = "PRODUCTID")
	public String getProductId() {
		return productId;
	}

	public void setProductid(String productId) {
		this.productId = productId;
	}

	@DynamoDBAttribute(attributeName = "COLOR")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@DynamoDBAttribute(attributeName = "YEAR")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@DynamoDBAttribute(attributeName = "PRICE")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@DynamoDBAttribute(attributeName = "GENDER")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@DynamoDBAttribute(attributeName = "QUANTITY")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@DynamoDBAttribute(attributeName = "TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	@DynamoDBIgnore
	public String toString() {
		return "Product [pk=" + pk + ", sk=" + sk + ", data=" + data + ", size=" + size + ", productId=" + productId
				+ ", color=" + color + ", year=" + year + ", price=" + price + ", gender=" + gender + ", quantity="
				+ quantity + ", type=" + type + "]";
	}

}
