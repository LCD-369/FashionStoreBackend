package com.teamalpha.fashionstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamalpha.fashionstore.service.MemberService;

@RestController
@RequestMapping(path="/api")
public class MemberController {

	@Autowired
	MemberService memberService;
	
}
