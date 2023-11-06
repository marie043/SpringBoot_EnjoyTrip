package com.ssafy.enjoy.member.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoy.member.model.LoginTry;

@Mapper
public interface LogintryMapper {
	LoginTry readLoginTry(String id, String ip) throws SQLException;
}
