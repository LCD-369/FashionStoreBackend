package com.teamalpha.fashionstore.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.teamalpha.fashionstore.entity.Product;
import com.teamalpha.fashionstore.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Collection<Product> findAllProducts() {	
		return productRepository.findAll();
	}
}
