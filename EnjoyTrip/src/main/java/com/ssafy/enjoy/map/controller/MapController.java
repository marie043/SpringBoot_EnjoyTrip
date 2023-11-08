package com.ssafy.enjoy.map.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoy.map.model.service.MapService;

@RestController
@RequestMapping("/map")
public class MapController {
	
	@Autowired
	MapService mapService;
	
	@GetMapping("/sido")
	public Map<String, Object> getSido(){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<Map> list = mapService.getSido();
			result.put("msg", "OK");
			result.put("detail","loaded city info");
		}catch(Exception e) {
			e.printStackTrace();
			result.put("msg", "NO");
			result.put("detail", "fail to load city info");
		}
		return result;
	}
	
	@GetMapping("/gugun")
	public Map<String, Object> getGugun(){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<Map> list = mapService.getGugun();
			result.put("msg", "OK");
			result.put("detail", "loaded section info");
		}catch(Exception e) {
			e.printStackTrace();
			result.put("msg", "NO");
			result.put("detail", "fail to load section info");
		}
		return result;
	}
}
