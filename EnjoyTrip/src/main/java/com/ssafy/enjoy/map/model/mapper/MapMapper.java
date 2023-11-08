package com.ssafy.enjoy.map.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MapMapper {

	List<Map> readSido() throws SQLException;

	List<Map> readGugun() throws SQLException;

}
