package com.yougou.db;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBHelper {
	//创建一个数据源
	private static DataSource ds = null;
	private static Context context = null;
	//使用本地线程来确保多线程并发时的安全性
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//已进入就要加载的内容
	static {
		try {	
			context = new InitialContext();
			//创建数据源
			ds = (DataSource)context.lookup("java:comp/env/jdbc/mysql");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//创建数据库连接
	public static Connection getConnection() {
		Connection conn = tl.get();
		try {
			if(conn == null){
				conn = ds.getConnection();
				tl.set(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭数据库连接
	public static void closeConnection() {
		Connection conn = tl.get();
		try {
			if(conn!=null && !conn.isClosed()){
				conn.close();
				tl.set(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
