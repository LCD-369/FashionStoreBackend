package com.teamalpha.fashionstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamalpha.fashionstore.service.CouponService;

@RestController
@RequestMapping(path="/api")
public class CouponController {
	
	@Autowired
	CouponService couponService;
	
	
}
