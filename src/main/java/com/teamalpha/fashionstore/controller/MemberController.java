package com.teamalpha.fashionstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamalpha.fashionstore.entity.Member;
import com.teamalpha.fashionstore.service.MemberService;

@RestController
@RequestMapping(path="/api")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@PostMapping(value="/member/add")
	public ResponseEntity<?> addMember(@RequestBody final Member member) {
		String message = memberService.addMemberAccount(member);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
}
