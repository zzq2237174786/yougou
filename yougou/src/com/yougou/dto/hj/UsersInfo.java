package com.yougou.dto.hj;

import java.io.Serializable;

public class UsersInfo implements Serializable{
	private String usersNum;
	private String loginTime;
	private String usersIp;
	public String getUsersNum() {
		return usersNum;
	}
	public void setUsersNum(String usersNum) {
		this.usersNum = usersNum;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getUsersIp() {
		return usersIp;
	}
	public void setUsersIp(String usersIp) {
		this.usersIp = usersIp;
	}
}
