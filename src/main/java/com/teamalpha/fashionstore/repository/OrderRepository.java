package com.teamalpha.fashionstore.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.InternalServerErrorException;
import com.amazonaws.services.dynamodbv2.model.ItemCollectionSizeLimitExceededException;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputExceededException;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.teamalpha.fashionstore.entity.Order;

@Repository
public class OrderRepository {

	@Autowired
	AmazonDynamoDB dynamoDB;

	public void addNewOrder(Order order) {
		try {

			PutItemRequest putItemRequest = createPutItemRequest(order);
			PutItemResult putItemResult = dynamoDB.putItem(putItemRequest);
			System.out.println("Successfully put item.");

		} catch (Exception e) {
			handlePutItemErrors(e);
		}
	}

	private static PutItemRequest createPutItemRequest(Order order) {
		PutItemRequest putItemRequest = new PutItemRequest();
		putItemRequest.setTableName("FashionrusStore");
		putItemRequest.setItem(getItem(order));
		return putItemRequest;
	}

	private static Map<String, AttributeValue> getItem(Order order) {
		Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
		item.put("PK", new AttributeValue(order.getPk()));
		item.put("SK", new AttributeValue(order.getSk()));
		item.put("ORDERID", new AttributeValue(order.getOrderId()));
		item.put("USERNAME", new AttributeValue(order.getUsername()));
		item.put("ORDERDATE", new AttributeValue(order.getOrderDate()));
		item.put("PRODUCTID", new AttributeValue(order.getProductId()));
		item.put("TOTALSALE", new AttributeValue(order.getTotalSale()));
		return item;
	}

	private static void handlePutItemErrors(Exception exception) {
		try {
			throw exception;
		} catch (ConditionalCheckFailedException ccfe) {
			System.out.println("Condition check specified in the operation failed, review and update the condition "
					+ "check before retrying. Error: " + ccfe.getErrorMessage());
		} catch (TransactionException tce) {
			System.out.println("Operation was rejected because there is an ongoing transaction for the item, generally "
					+ "safe to retry with exponential back-off. Error: " + tce.getMessage());
		} catch (ItemCollectionSizeLimitExceededException icslee) {
			System.out.println("An item collection is too large, you\'re using Local Secondary Index and exceeded "
					+ "size limit of items per partition key. Consider using Global Secondary Index instead. Error: "
					+ icslee.getErrorMessage());
		} catch (Exception e) {
			handleCommonErrors(e);
		}
	}

	private static void handleCommonErrors(Exception exception) {
		try {
			throw exception;
		} catch (InternalServerErrorException isee) {
			System.out.println("Internal Server Error, generally safe to retry with exponential back-off. Error: "
					+ isee.getErrorMessage());
		} catch (RequestRejectedException rlee) {
			System.out.println(
					"Throughput exceeds the current throughput limit for your account, increase account level throughput before "
							+ "retrying. Error: " + rlee.getMessage());
		} catch (ProvisionedThroughputExceededException ptee) {
			System.out.println(
					"Request rate is too high. If you're using a custom retry strategy make sure to retry with exponential back-off. "
							+ "Otherwise consider reducing frequency of requests or increasing provisioned capacity for your table or secondary index. Error: "
							+ ptee.getErrorMessage());
		} catch (ResourceNotFoundException rnfe) {
			System.out.println("One of the tables was not found, verify table exists before retrying. Error: "
					+ rnfe.getErrorMessage());
		} catch (AmazonServiceException ase) {
			System.out.println(
					"An AmazonServiceException occurred, indicates that the request was correctly transmitted to the DynamoDB "
							+ "service, but for some reason, the service was not able to process it, and returned an error response instead. Investigate and "
							+ "configure retry strategy. Error type: " + ase.getErrorType() + ". Error message: "
							+ ase.getErrorMessage());
		} catch (AmazonClientException ace) {
			System.out.println(
					"An AmazonClientException occurred, indicates that the client was unable to get a response from DynamoDB "
							+ "service, or the client was unable to parse the response from the service. Investigate and configure retry strategy. "
							+ "Error: " + ace.getMessage());
		} catch (Exception e) {
			System.out.println(
					"An exception occurred, investigate and configure retry strategy. Error: " + e.getMessage());
		}
	}
}
