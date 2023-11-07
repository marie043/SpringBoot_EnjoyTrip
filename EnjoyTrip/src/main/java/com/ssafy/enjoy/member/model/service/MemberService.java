package com.ssafy.enjoy.member.model.service;

import com.ssafy.enjoy.member.model.Member;

public interface MemberService {

	Member loginMember(Member member, String ip) throws Exception;

	int idCheck(String id) throws Exception;

	void joinMember(Member member) throws Exception;

}
