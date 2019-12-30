package com.yougou.util;

public class JsonSuccess {
	private static final String MSG = "{\"code\":0 , \"message\":\"商品获取成功\" , \"data\":";
	public static String success(String data) {
		StringBuffer sb = new StringBuffer(MSG);
		sb.append(data+"}");
		return sb.toString();
	}
}
