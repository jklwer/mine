package com.kh.spring.member.model.repository;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MemberRepository {

	@Select("select password from member where user_id = #{userId}")
	String getPassword(@Param("userId") String userId);
	
}
