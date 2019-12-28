package com.yougou.web.servlet.form;

import com.yougou.web.core.ActionForm;

/**
 * 保存页面的参数
 * @author Administrator
 *
 */
public class LoginForm extends ActionForm{
	private String uname;
	private String upwd;
	private String sex;
	private String first;
	private String second;
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "LoginForm [uname=" + uname + ", upwd=" + upwd + ", sex=" + sex + ", first=" + first + ", second="
				+ second + "]";
	}
	
	
	
	
}
