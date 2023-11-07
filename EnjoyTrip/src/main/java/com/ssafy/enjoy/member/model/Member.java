package com.ssafy.enjoy.member.model;

public class Member {
	private String userId;
	private String userName;
	private String userPassword;
	private String emailId;
	private String emailDomain;
	private String joinDate;
	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", emailId="
				+ emailId + ", emailDomain=" + emailDomain + ", joinDate=" + joinDate + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPassword;
	}
	public void setUserPwd(String userPwd) {
		this.userPassword = userPwd;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
}
