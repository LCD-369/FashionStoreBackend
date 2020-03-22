package com.teamalpha.fashionstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamalpha.fashionstore.entity.Member;
import com.teamalpha.fashionstore.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	public String addMemberAccount(Member member) {	
		return memberRepository.addNewMember(member);
	}
	
}
