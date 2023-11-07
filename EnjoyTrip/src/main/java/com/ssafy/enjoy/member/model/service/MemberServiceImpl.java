package com.ssafy.enjoy.member.model.service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.enjoy.member.model.IdInfo;
import com.ssafy.enjoy.member.model.KeyInfo;
import com.ssafy.enjoy.member.model.LoginTry;
import com.ssafy.enjoy.member.model.Member;
import com.ssafy.enjoy.member.model.mapper.IdInfoMapper;
import com.ssafy.enjoy.member.model.mapper.KeyInfoMapper;
import com.ssafy.enjoy.member.model.mapper.LogintryMapper;
import com.ssafy.enjoy.member.model.mapper.MemberMapper;
import com.ssafy.util.OpenCrypt;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Autowired
	LogintryMapper logintryMapper;

	@Autowired
	IdInfoMapper idInfoMapper;

	@Autowired
	KeyInfoMapper keyInfoMapper;

	@Override
	public Member loginMember(Member member, String ip) throws Exception {
		try {
			LoginTry loginTry = logintryMapper.readLoginTry(ip);
			System.out.println(loginTry);
			Date today = new Date();
			Time now = new Time(today.getHours(), today.getMinutes() - 30, today.getSeconds());
			if (loginTry.getRetry() >= 5 && today == loginTry.getLast_try_date()
					&& loginTry.getLast_try_time().after(now)) {
				throw new Exception("login try limit 30min");
			}
			if (memberMapper.idCheck(member.getUserId()) != 1) {
				throw new Exception("no such user");
			}
			IdInfo idInfo = idInfoMapper.readIdInfo(member.getUserId());
			System.out.println(idInfo);
			String hashed_id = OpenCrypt.byteArrayToHex(OpenCrypt.getSHA256(member.getUserId(), idInfo.getSalt()));
			KeyInfo keyInfo = keyInfoMapper.readKeyInfo(hashed_id);
			byte[] key = OpenCrypt.hexToByteArray(keyInfo.getKey());
			String cUserPwd = OpenCrypt.aesEncrypt(member.getUserPwd(), key);
			String hashed_cUserPwd = OpenCrypt.byteArrayToHex(OpenCrypt.getSHA256(cUserPwd, keyInfo.getSalt()));
			return memberMapper.readMember(member.getUserId(), hashed_cUserPwd);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new Exception("Server error");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Server error");
		}
	}

	@Override
	public int idCheck(String id) throws Exception {
		try {
			return memberMapper.idCheck(id);
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Server error");
		}
	}

}
