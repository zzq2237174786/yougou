package com.yougou.web.core;

public class ActionForm {
	//默认的方法名
	private String method = "deMethod";
	
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	//可以做验证功能
	public boolean validate() {
		return true;
	}
}
