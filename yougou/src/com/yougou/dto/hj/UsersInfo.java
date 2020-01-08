package com.yougou.dto.hj;

import java.io.Serializable;
import java.util.Date;

public class UsersInfo implements Serializable{
	private String usersNum; //用户
	private Date loginTime;//时间
	private String usersIp;//ip地址
	public String getUsersNum() {
		return usersNum;
	}
	public void setUsersNum(String usersNum) {
		this.usersNum = usersNum;
	}	
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getUsersIp() {
		return usersIp;
	}
	public void setUsersIp(String usersIp) {
		this.usersIp = usersIp;
	}
}
