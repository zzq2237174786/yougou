package com.yougou.util;
/**
 * ������
 * @author Administrator
 *
 */

import java.util.ArrayList;
import java.util.List;
/**
 * 字符串拆分  逗号拆分
 * @author Administrator
 *
 */
public class Resolver {
	public static List<String> resolver(String msg){
		 List<String> list = new ArrayList<>();
		String[] filedAll = msg.split(",");
		for (int i = 0; i < filedAll.length; i++) {
			list.add(filedAll[i]);
		}
		return list;
	}	
	//}拆分
	public static List<String> resolver1(String msg){
		 List<String> list = new ArrayList<>();
		String[] filedAll = msg.split("}");
		for (int i = 0; i < filedAll.length; i++) {
			list.add(filedAll[i]);
		}
		return list;
	}	
}





