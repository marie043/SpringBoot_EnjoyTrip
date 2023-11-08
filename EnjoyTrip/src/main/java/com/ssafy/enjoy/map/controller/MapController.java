package com.ssafy.enjoy.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoy.map.model.service.MapService;

@RestController
@RequestMapping("/map")
public class MapController {
	
	@Autowired
	MapService mapService;
}
