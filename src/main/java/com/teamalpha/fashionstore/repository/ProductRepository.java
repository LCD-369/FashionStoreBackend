package com.teamalpha.fashionstore.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.teamalpha.fashionstore.entity.Product;

@Repository
public class ProductRepository {

	@Autowired
	AmazonDynamoDB dynamoDB;
	
	private ScanResult scanResult;

	public Collection<Product> findAll() {	
		final Collection<Product> products = new ArrayList<>();
		try {
		ScanRequest scanRequest = findAllScanRequest();
		scanResult = dynamoDB.scan(scanRequest);
		
		products.addAll((Collection<? extends Product>) scanResult.getItems().stream().collect(Collectors.toList()));
		 } catch (Exception e) {
	            handlePutItemErrors(e);
	     } 
		return products;
	    
	};

	private static ScanRequest findAllScanRequest() {
		Map<String, String> expressionAttributeNames = new HashMap<String, String>();
		expressionAttributeNames.put("#8f150", "SK");
		Map<String, AttributeValue> expressionAttributeValues = new HashMap<String, AttributeValue>();
		expressionAttributeValues.put(":8f150", new AttributeValue("PRODUCT"));

		ScanRequest scanRequest = new ScanRequest();
		scanRequest.setTableName("FashionrusStore");
		String filterExpression = "#8f150 = :8f150";
		scanRequest.setFilterExpression(filterExpression);
		scanRequest.setConsistentRead(false);
		scanRequest.setExpressionAttributeNames(expressionAttributeNames);
		scanRequest.setExpressionAttributeValues(expressionAttributeValues);
		return scanRequest;
	}
	
	private static void handlePutItemErrors(Exception exception) {
        try {
            throw exception;
        } catch (ConditionalCheckFailedException ccfe) {
            System.out.println("Condition check specified in the operation failed, review and update the condition " +
                "check before retrying. Error: " + ccfe.getErrorMessage());
        } catch (TransactionException tce) {
            System.out.println("Operation was rejected because there is an ongoing transaction for the item, generally " +
                "safe to retry with exponential back-off. Error: " + tce.getMessage());
        } catch (ItemCollectionSizeLimitExceededException icslee) {
            System.out.println("An item collection is too large, you\'re using Local Secondary Index and exceeded " +
                "size limit of items per partition key. Consider using Global Secondary Index instead. Error: " + icslee.getErrorMessage());
        } catch (Exception e) {
            handleCommonErrors(e);
        }
    }

    private static void handleCommonErrors(Exception exception) {
        try {
            throw exception;
        } catch (InternalServerErrorException isee) {
            System.out.println("Internal Server Error, generally safe to retry with exponential back-off. Error: " + isee.getErrorMessage());
        } catch (RequestRejectedException rlee) {
            System.out.println("Throughput exceeds the current throughput limit for your account, increase account level throughput before " + 
                "retrying. Error: " + rlee.getMessage());
        } catch (ProvisionedThroughputExceededException ptee) {
            System.out.println("Request rate is too high. If you're using a custom retry strategy make sure to retry with exponential back-off. " +
                "Otherwise consider reducing frequency of requests or increasing provisioned capacity for your table or secondary index. Error: " + 
                ptee.getErrorMessage());
        } catch (ResourceNotFoundException rnfe) {
            System.out.println("One of the tables was not found, verify table exists before retrying. Error: " + rnfe.getErrorMessage());
        } catch (AmazonServiceException ase) {
            System.out.println("An AmazonServiceException occurred, indicates that the request was correctly transmitted to the DynamoDB " + 
                "service, but for some reason, the service was not able to process it, and returned an error response instead. Investigate and " +
                "configure retry strategy. Error type: " + ase.getErrorType() + ". Error message: " + ase.getErrorMessage());
        } catch (AmazonClientException ace) {
            System.out.println("An AmazonClientException occurred, indicates that the client was unable to get a response from DynamoDB " +
                "service, or the client was unable to parse the response from the service. Investigate and configure retry strategy. "+
                "Error: " + ace.getMessage());
        } catch (Exception e) {
            System.out.println("An exception occurred, investigate and configure retry strategy. Error: " + e.getMessage());
        }
    }
	
}
