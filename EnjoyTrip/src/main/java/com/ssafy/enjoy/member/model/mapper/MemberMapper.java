package com.ssafy.enjoy.member.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoy.member.model.Member;

@Mapper
public interface MemberMapper {

	int idCheck(String id) throws Exception ;

	Member readMember(String id, String pw) throws SQLException;

	void createMember(Member member) throws SQLException;

}
