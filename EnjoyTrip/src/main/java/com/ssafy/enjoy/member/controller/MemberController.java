package com.ssafy.enjoy.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoy.member.model.MemberDto;

@RestController
@RequestMapping("/user")
public class MemberController {
	@GetMapping("/login")
	public Map<String, String> Member(@RequestBody String id, HttpSession session){
		Map<String, String> result = new HashMap<String, String>();
		if(id==null) {
			result.put("msg", "NO");
			result.put("detail", "no input id");
		}else {
			if(id.equals(session.getAttribute("id"))) {
				result.put("msg", "OK");
			}else {
				result.put("msg", "NO");
				result.put("detail", "no matching id");
			}
		}
		return result;
	}
	public Map<String, String> Member(@RequestBody MemberDto member, HttpSession session){
		Map<String, String> result = new HashMap<String, String>();
		if(member.getUserId()==null||member.getUserPwd()==null) {
			result.put("msg", "NO");
			result.put("detail", "no id or no pw");
		}else {
			
		}
		return result;
	}
}
