package com.ssafy.enjoy.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoy.member.model.MemberDto;
import com.ssafy.enjoy.member.model.service.MemberService;

@RestController
@RequestMapping("/user")
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("/session")
	public Map<String, String> sessionCheck(@RequestBody MemberDto member, HttpSession session) {
		Map<String, String> result = new HashMap<String, String>();
		if (member == null||member.getUserId()==null||member.getUserPwd()==null) {
			result.put("msg", "NO");
			result.put("detail", "no input id");
		} else {
			MemberDto userinfo = (MemberDto) session.getAttribute("userinfo");
			if(userinfo==null) {
				result.put("msg", "NO");
				result.put("detail", "already logout or session expired");
			}else if (member.getUserId().equals(userinfo.getUserId())&&member.getUserPwd().equals(userinfo.getUserPwd())) {
				result.put("msg", "OK");
				result.put("detail", "login success");
				result.put("name", userinfo.getUserName());
				result.put("email_id", userinfo.getEmailId());
				result.put("email_domain", userinfo.getEmailDomain());
			} else {
				result.put("msg", "NO");
				result.put("detail", "no matching id or password");
			}
		}
		return result;
	}

	@PostMapping("/login")
	public Map<String, String> login(@RequestBody MemberDto member, HttpSession session){
		Map<String, String> result = new HashMap<String, String>();
		if(member.getUserId()==null||member.getUserPwd()==null) {
			result.put("msg", "NO");
			result.put("detail", "no id or no pw");
		}else {
			try {
				member = memberService.loginMember(member);
				session.setAttribute("userinfo", member);
				result.put("msg", "OK");
				result.put("detail", "login success");
				result.put("name", member.getUserName());
				result.put("email_id", member.getEmailId());
				result.put("email_domain", member.getEmailDomain());
			}catch(Exception e) {
				e.printStackTrace();
				result.put("msg", "No");
				result.put("detail", e.getMessage());
			}
		}
		return result;
	}
}
