package com.yougou.pojo;

import java.io.Serializable;

public class Users implements Serializable{
	private String usersNum;
	private byte[] usersPwd;
	private int usersMSum;
	private int usersPTime;
	

	public byte[] getUsersPwd() {
		return usersPwd;
	}

	public void setUsersPwd(byte[] usersPwd) {
		this.usersPwd = usersPwd;
	}

	public int getUsersMSum() {
		return usersMSum;
	}

	public void setUsersMSum(int usersMSum) {
		this.usersMSum = usersMSum;
	}

	public int getUsersPTime() {
		return usersPTime;
	}

	public void setUsersPTime(int usersPTime) {
		this.usersPTime = usersPTime;
	}

	public Users() {
	}
	
	public String getUsersNum() {
		return usersNum;
	}
	public void setUsersNum(String usersNum) {
		this.usersNum = usersNum;
	}
}
