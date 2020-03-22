package com.teamalpha.fashionstore.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "FashionrusStore")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pk;
	private String sk;
	private String cardNo;
	private String exp;
	private String fullName;
	private String type;
	private String cvv;
	
	public Payment() {
		
	}

	public Payment(String pk, String sk, String cardNo, String exp, String fullName, String type, String cvv) {
		this.pk = pk;
		this.sk = sk;
		this.cardNo = cardNo;
		this.exp = exp;
		this.fullName = fullName;
		this.type = type;
		this.cvv = cvv;
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
	@DynamoDBAttribute(attributeName = "CARDNO")
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@DynamoDBAttribute(attributeName = "EXP")
	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}
	@DynamoDBAttribute(attributeName = "FULLNAME")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@DynamoDBAttribute(attributeName = "TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@DynamoDBAttribute(attributeName = "CVV")
	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	
}
