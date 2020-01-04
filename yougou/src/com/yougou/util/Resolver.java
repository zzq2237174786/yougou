package com.yougou.util;
/**
 * ������
 * @author Administrator
 *
 */

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 字符串拆分  逗号拆分
 * @author Administrator
 *
 */
public class Resolver {
	//逗号分割
	public static List<String> resolver(String msg){
		 List<String> list = new ArrayList<>();
		String[] filedAll = msg.split(",");
		for (int i = 0; i < filedAll.length; i++) {
			list.add(filedAll[i]);
		}
		return list;
	}	
	
	
	//拆分图片数据变成json数据拼接的数据
	public static String resolverImg(String msg){
		JSONObject obj= JSONObject.fromObject(msg);
		List<String> list = new ArrayList<>();
		for(int i = 0; i < obj.size(); i++) {
			String str = obj.getString("group"+(i+1));
			list.add(str);
		}
		return JSONArray.fromObject(list).toString();
	}	
	
	//拆分尺码
	public static List<String> resolverSize(String msg){
		if(msg==null) {return null;}
		JSONObject obj= JSONObject.fromObject(msg);
		List<String> list = new ArrayList<>();
		for(int i = 0; i < obj.size(); i++) {
			String str = obj.getString("line"+(i+1));
			//System.out.println(str);
			String[] filedAll = str.split(",");
			for (int j = 0; j < filedAll.length; j++) {
				list.add(filedAll[j]);
			}
			//list.add(filedAll[i]);
			//list=resolver(str);
			//System.out.println(list);
		}
		return list;
	}	
	
	
	
	
}





