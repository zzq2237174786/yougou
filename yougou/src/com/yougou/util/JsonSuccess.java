package com.yougou.util;

public class JsonSuccess {
	private static final String MSG = "{\"code\":0 , \"message\":\"商品获取成功\" , \"data\":";
	private static final String MSGF = "{\"code\":1 , \"message\":\"商品获取失败\" , \"data\":";
	public static String success(String data) {
		if(data==null) {
			StringBuffer sb = new StringBuffer(MSGF);
			sb.append(data+"}");
			return sb.toString();
		}else {
			StringBuffer sb = new StringBuffer(MSG);
			sb.append(data+"}");
			return sb.toString();
		}
	}
}
