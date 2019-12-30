package com.yougou.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import com.yougou.dao.BaseDao;
import com.yougou.db.DBHelper;

public class BaseDaoImpl implements BaseDao {
	// 查询一个
	public Object selectMethod(Object p, Connection conn, String sqlId) throws Exception {
		Class PC = p.getClass();

		// 准备一个map集合用来储存要设的属性
		Map<Integer, String> map = new HashMap<>();
		// 准备一个集合用来储存返回的对象
		List<Object> list = new ArrayList<>();
		// 查找映射文件
		Document doc = DBHelper.getDocumentByClass(PC);

		// 通过映射文件查找查询语句
		Element element = (Element) doc.selectSingleNode("/class/select[@sqlId='" + sqlId + "']");
		// 得到语句
		String sql = element.getTextTrim();
		// 将标识替换为问号
		String regex = "#[{](\\w+)[}]";
		Pattern pt = Pattern.compile(regex);
		Matcher ma = pt.matcher(sql);
		int parameterCount = 0;
		// 查找
		while (ma.find()) {
			parameterCount++;
			// 将得到的值存入map集合
			map.put(parameterCount, ma.group(1));
		}
		sql = sql.replaceAll(regex, "?");
		// 查询
		PreparedStatement ps = conn.prepareStatement(sql);
		// 设值
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		for (Map.Entry<Integer, String> entry : set) {
			// 通过属性得到对象的属性值
			Field field = PC.getDeclaredField(entry.getValue());
			field.setAccessible(true);
			// 设值
			ps.setObject(entry.getKey(), field.get(p));
		}
		ResultSet rs = ps.executeQuery();

		// 得到返回类型
		Attribute ab = (Attribute) doc.selectSingleNode("/class/select[@sqlId='" + sqlId + "']/@resultType");
		// 通过类加载器得到这个对象
		String reslutType = null;
		Class reslutClass = null;
		if (ab != null) {
			reslutType = ab.getValue();
			reslutClass = Class.forName(reslutType);
		}
		// 因为用户数据可能查询不是全部数据 所以用元数据
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();

		// 得到数据
		while (rs.next()) {
			Object obj = reslutClass.newInstance();
			for (int i = 1; i <= columns; i++) {
				String columnName = rsmd.getColumnName(i);
				Attribute attrName = (Attribute) doc.selectSingleNode("/class/*[@column='" + columnName + "']/@name");
				Field f = PC.getDeclaredField(attrName.getValue());
				f.setAccessible(true);
				f.set(obj, rs.getObject(columnName));
			}
			list.add(obj);
		}
		return list;
	}

	// 增加一个数据
	public boolean insertMethod(Object p, Connection conn, String sqlId) throws Exception {
		Class PC = p.getClass();
		// 准备一个map集合用来储存要设的属性
		Map<Integer, String> map = new HashMap<>();
		// 查找映射文件
		Document doc = DBHelper.getDocumentByClass(PC);
		// 通过映射文件查找查询语句
		Element element = (Element) doc.selectSingleNode("/class/insert[@sqlId='" + sqlId + "']");
		// 得到语句
		String sql = element.getTextTrim();
		// 将标识替换为问号
		String regex = "#[{](\\w+)[}]";
		Pattern pt = Pattern.compile(regex);
		Matcher ma = pt.matcher(sql);
		int parameterCount = 0;
		// 查找
		while (ma.find()) {
			parameterCount++;
			// 将得到的值存入map集合
			map.put(parameterCount, ma.group(1));
		}
		sql = sql.replaceAll(regex, "?");
		// 查询
		PreparedStatement ps = conn.prepareStatement(sql);
		// 设值
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		for (Map.Entry<Integer, String> entry : set) {
			// 通过属性得到对象的属性值
			Field field = PC.getDeclaredField(entry.getValue());
			field.setAccessible(true);
			// 设值
			ps.setObject(entry.getKey(), field.get(p));
		}
		int result = ps.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 删除一个
	public boolean deleteMethod(Object obj, Connection conn, String sqlId) throws Exception {
		Class PC = obj.getClass();
		// 准备一个map集合用来储存要设的属性
		Map<Integer, String> map = new HashMap<>();

		// 查找映射文件
		Document doc = DBHelper.getDocumentByClass(PC);
		// 通过映射文件查找查询语句
		Element element = (Element) doc.selectSingleNode("/class/delete[@sqlId='" + sqlId + "']");
		// 得到语句
		String sql = element.getTextTrim();
		// 将标识替换为问号
		String regex = "#[{](\\w+)[}]";
		sql = sql.replaceAll(regex, "?");
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, "");
		int result = ps.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 修改信息
	public boolean updateMethod(Object p, Connection conn, String sqlId) throws Exception {
		Class PC = p.getClass();
		// 准备一个map集合用来储存要设的属性
		Map<Integer, String> map = new HashMap<>();
		// 查找映射文件
		Document doc = DBHelper.getDocumentByClass(PC);
		// 通过映射文件查找查询语句
		Element element = (Element) doc.selectSingleNode("/class/update[@sqlId='" + sqlId + "']");
		// 得到语句
		String sql = element.getTextTrim();
		// 将标识替换为问号
		String regex = "#[{](\\w+)[}]";
		Pattern pt = Pattern.compile(regex);
		Matcher ma = pt.matcher(sql);
		int parameterCount = 0;
		// 查找
		while (ma.find()) {
			parameterCount++;
			// 将得到的值存入map集合
			map.put(parameterCount, ma.group(1));
		}
		sql = sql.replaceAll(regex, "?");
		// 查询
		PreparedStatement ps = conn.prepareStatement(sql);
		// 设值
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		for (Map.Entry<Integer, String> entry : set) {
			// 通过属性得到对象的属性值
			Field field = PC.getDeclaredField(entry.getValue());
			field.setAccessible(true);
			// 设值
			ps.setObject(entry.getKey(), field.get(p));
		}
		int retrun = ps.executeUpdate();
		if (retrun > 0) {
			return true;
		}
		return false;
	}

	// 增加多个数据
	public boolean insertMoreMethod(List<Object> list, Connection conn, String sqlId) throws Exception {
		Class PC = list.get(0).getClass();
		// 准备一个map集合用来储存要设的属性
		Map<Integer, String> map = new HashMap<>();
		// 查找映射文件
		Document doc = DBHelper.getDocumentByClass(PC);
		// 通过映射文件查找查询语句
		Element element = (Element) doc.selectSingleNode("/class/insert[@sqlId='" + sqlId + "']");
		// 得到语句
		String sql = element.getTextTrim();
		// 将标识替换为问号
		String regex = "#[{](\\w+)[}]";
		Pattern pt = Pattern.compile(regex);
		Matcher ma = pt.matcher(sql);
		int parameterCount = 0;
		// 查找
		while (ma.find()) {
			parameterCount++;
			// 将得到的值存入map集合
			map.put(parameterCount, ma.group(1));
		}
		sql = sql.replaceAll(regex, "?");
		int result = 0;
		// 循环插入
		for (Object object : list) {
			Object p = object;
			PreparedStatement ps = conn.prepareStatement(sql);
			// 设值
			Set<Map.Entry<Integer, String>> set = map.entrySet();
			for (Map.Entry<Integer, String> entry : set) {
				// 通过属性得到对象的属性值
				Field field = PC.getDeclaredField(entry.getValue());
				field.setAccessible(true);
				// 设值
				ps.setObject(entry.getKey(), field.get(p));
			}
			result = ps.executeUpdate();
			//有一条数据没差进去就失败
			if (result <= 0) {
				return false;
			}
		}
		return true;
	}
}
