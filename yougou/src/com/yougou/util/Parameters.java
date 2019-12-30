package com.yougou.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;import org.apache.commons.collections.iterators.EntrySetMapIterator;
import org.apache.log4j.Logger;import com.sun.xml.internal.stream.Entity;
import com.yougou.pojo.Users;

/**
 * 给对象参数设值
 * @author Administrator
 *
 */
public class Parameters {
	public static void setParameter(Object obj,Map<String, Object> map) {
		Logger log = Logger.getLogger(Parameters.class);
		Class o = obj.getClass();
		//循环集合里的方法名 和值
		Set<Map.Entry<String, Object>> set =  map.entrySet();
		for (Map.Entry<String, Object> entry : set) {
			try {
				// 通过属性得到对象的属性值
				Field field = o.getDeclaredField(entry.getKey());
				field.setAccessible(true);
				// 设值
				field.set(obj, entry.getValue());
			} catch (Exception e) {
				log.error("对象赋值错误", e);
			}
			
		}		
	}
}
