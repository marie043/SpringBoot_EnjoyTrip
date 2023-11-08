package com.ssafy.enjoy.map.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.enjoy.map.model.mapper.MapMapper;

@Service
public class MapServiceImpl implements MapService {

	@Autowired
	MapMapper mapMapper;
}
