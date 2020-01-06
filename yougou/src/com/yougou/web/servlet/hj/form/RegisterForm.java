package com.yougou.web.servlet.hj.form;

import com.yougou.web.core.ActionForm;

/**
 * 保存页面的参数
 * @author Administrator
 *
 */
public class RegisterForm extends ActionForm{
	private String usersName;
	private String usersPwd;
	private String usersEmail;
	private String usersPTime;
	private String usersMSum;
	
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
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
