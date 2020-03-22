package com.teamalpha.fashionstore.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "FashionrusStore")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pk;
	private String sk;
	private String orderId;
	private String username;
	private String orderDate;
	private String productId;
	private String totalSale;

	public Order() {

	}

	public Order(String pk, String sk, String orderId, String username, String orderDate, String productId,
			String totalSale) {
		this.pk = pk;
		this.sk = sk;
		this.orderId = orderId;
		this.username = username;
		this.orderDate = orderDate;
		this.productId = productId;
		this.totalSale = totalSale;
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

	@DynamoDBAttribute(attributeName = "ORDERID")
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@DynamoDBAttribute(attributeName = "USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@DynamoDBAttribute(attributeName = "ORDERDATE")
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@DynamoDBAttribute(attributeName = "PRODUCTID")
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@DynamoDBAttribute(attributeName = "TOTALSALE")
	public String getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(String totalSale) {
		this.totalSale = totalSale;
	}

	@Override
	public String toString() {
		return "Order [pk=" + pk + ", sk=" + sk + ", orderId=" + orderId + ", username=" + username + ", orderDate="
				+ orderDate + ", productId=" + productId + ", totalSale=" + totalSale + "]";
	}

}
