package com.teamalpha.fashionstore.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "FashionrusStore")
public class Coupon implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pk;
	private String sk;
	private String couponCode;
	private String discount;
	private String month;
	private String year;

	public Coupon() {

	}

	public Coupon(String pk, String sk, String couponCode, String discount, String month, String year) {

		this.pk = pk;
		this.sk = sk;
		this.couponCode = couponCode;
		this.discount = discount;
		this.month = month;
		this.year = year;
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

	@DynamoDBAttribute(attributeName = "COUPONCODE")
	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@DynamoDBAttribute(attributeName = "DISCOUNT")
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	@DynamoDBAttribute(attributeName = "MONTH")
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@DynamoDBAttribute(attributeName = "YEAR")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
