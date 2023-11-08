package com.ssafy.enjoy.map.model.service;

import java.util.List;
import java.util.Map;

public interface MapService {

	List<Map> getSido() throws Exception;

	List<Map> getGugun() throws Exception;

	List search(Map map) throws Exception;

}
