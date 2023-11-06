package com.ssafy.enjoy.member.model.service;

import com.ssafy.enjoy.member.model.MemberDto;

public interface MemberService {

	MemberDto loginMember(MemberDto member, String ip) throws Exception;

}
