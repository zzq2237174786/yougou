package com.yougou.web.servlet.hj.form;

import com.yougou.web.core.ActionForm;

public class LoginForm extends ActionForm{
	private String usersNum;
	private String usersPwd;
	public String getUsersNum() {
		return usersNum;
	}
	public void setUsersNum(String usersNum) {
		this.usersNum = usersNum;
	}
	public String getUsersPwd() {
		return usersPwd;
	}
	public void setUsersPwd(String usersPwd) {
		this.usersPwd = usersPwd;
	}	
}
