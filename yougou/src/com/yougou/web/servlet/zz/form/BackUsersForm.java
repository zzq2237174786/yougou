package com.yougou.web.servlet.zz.form;

import com.yougou.web.core.ActionForm;

public class BackUsersForm extends ActionForm {
	private String usersNum;
	private String usersPwd;
	private String usersEmail;
	private String usersPTime;
	private String usersMSum;
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
	public String getUsersEmail() {
		return usersEmail;
	}
	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}
	public String getUsersPTime() {
		return usersPTime;
	}
	public void setUsersPTime(String usersPTime) {
		this.usersPTime = usersPTime;
	}
	public String getUsersMSum() {
		return usersMSum;
	}
	public void setUsersMSum(String usersMSum) {
		this.usersMSum = usersMSum;
	}
	
}
