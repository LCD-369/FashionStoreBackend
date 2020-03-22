package com.teamalpha.fashionstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.teamalpha.fashionstore.entity.HttpResponse;
import com.teamalpha.fashionstore.entity.Product;
import com.teamalpha.fashionstore.service.ProductService;

@RestController
@RequestMapping(path="/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value="/products/search")
	public ResponseEntity<?> getAllProducts() {
		Iterable<Product> products = productService.findAllProducts();
		if(products.iterator().next() == null) {
			 return new ResponseEntity<>(new HttpResponse("", "NO-Content", "Could not find resource"), HttpStatus.NO_CONTENT);
		}
		System.out.println(products);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
