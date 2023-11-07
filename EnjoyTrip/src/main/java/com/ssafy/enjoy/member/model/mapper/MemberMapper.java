package com.ssafy.enjoy.member.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoy.member.model.Member;

@Mapper
public interface MemberMapper {

	int idCheck(String userId) throws Exception ;

	Member readMember(String userId, String hashed_cUserPwd) throws SQLException;

}
