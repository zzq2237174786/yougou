package com.yougou.db;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class DBHelper {
	private static Logger log = Logger.getLogger(DBHelper.class);
	// 准备一个文档加载对象
	private static SAXReader reader = new SAXReader();
	// 准备一个主映射文件的对象
	private static Document config = null;
	// 准备一个集合用来储存所有的映射文件的文档
	private static List<Document> allMapping = new ArrayList<Document>();
	// 创建一个数据源
	private static DataSource ds = null;
	private static Context context = null;
	// 使用本地线程来确保多线程并发时的安全性
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	// 已进入就要加载的内容
	static {
		try {
			context = new InitialContext();
			// 创建数据源
			ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
			// 加载主映射文件
			config = reader.read(DBHelper.class.getResourceAsStream("/sqlmap.xml"));
			// 加载驱动 从配置文件中获取路径
			// 加载所有的映射文件
			loadAllMapping();
		} catch (Exception e) {
			log.error("数据源创建失败，加载主映射文件失败", e);
		}
	}

	// 创建数据库连接
	public static Connection getConnection() {
		Connection conn = tl.get();
		try {
			if (conn == null) {
				conn = ds.getConnection();
				tl.set(conn);
			}
		} catch (Exception e) {
			log.error("数据库连接失败", e);
		}
		return conn;
	}

	// 关闭数据库连接
	public static void closeConnection() {
		Connection conn = tl.get();
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				tl.set(null);
			}
		} catch (Exception e) {
			log.error("数据库关闭失败", e);
		}
	}

	// 加载所有的映射文件
	private static void loadAllMapping() {
		// 找到配置文件中所有的path属性（映射文件路径）
		List<Attribute> attrList = config.selectNodes("//mapping/@path");
		try {
			// 通过主配置里面的属性找到所有的映射文件 加入集合
			for (int i = 0; i < attrList.size(); i++) {
				if (attrList != null && attrList.size() != 0) {
					Attribute attribute = attrList.get(i);
					// 记载映射文件
					Document document = reader.read(DBHelper.class.getResourceAsStream("/" + attribute.getValue()));
					allMapping.add(document);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 通过对象class找到对应的document
	public static Document getDocumentByClass(Class c) {
		try {
			// 循环集合
			for (int i = 0; i < allMapping.size(); i++) {
				// 找到文档的name属性路径
				Document doc = allMapping.get(i);
				Attribute attr = (Attribute) doc.selectSingleNode("/class/@name");
				if (c == Class.forName(attr.getValue())) {
					return doc;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
