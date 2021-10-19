package com.kh.spring.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;	//memberRepository 인터페이스 타입의 프록시 객체를 스프링 프레임워크가 생성해줌 
	
	public String selectPasswordById() {
		//System.out.println(memberRepository);	(출력값 : org.apache.ibatis.binding.MapperProxy@67bd2b25) - 프록시객체 
		return memberRepository.getPassword("dev"); 
	}
}
