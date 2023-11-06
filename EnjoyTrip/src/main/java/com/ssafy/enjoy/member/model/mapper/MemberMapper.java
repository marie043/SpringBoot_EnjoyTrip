package com.ssafy.enjoy.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoy.member.model.MemberDto;

@Mapper
public interface MemberMapper {

	int idCheck(String userId) throws Exception ;

	MemberDto readMember(String userId, String hashed_cUserPwd) throws Exception;

}
