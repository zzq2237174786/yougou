package com.yougou.pojo;

import java.io.Serializable;

public class Users implements Serializable{
	private String usersNum;
	private byte[] users_pwd;
	
	
	public Users() {
	}
	
	public String getUsersNum() {
		return usersNum;
	}
	public void setUsersNum(String usersNum) {
		this.usersNum = usersNum;
	}
	public byte[] getUsers_pwd() {
		return users_pwd;
	}
	public void setUsers_pwd(byte[] users_pwd) {
		this.users_pwd = users_pwd;
	}	
}
