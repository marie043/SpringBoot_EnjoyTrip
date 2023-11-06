package com.ssafy.enjoy.member.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoy.member.model.IdInfoDto;

@Mapper
public interface IdInfoMapper {

	IdInfoDto readIdInfo(String userId) throws SQLException;

}
