<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.yougou.dao.basedao.impl.BaseDaoImpl"%>
<%@page import="com.yougou.dao.basedao.BaseDao"%>
<%@page import="com.yougou.util.UsersPwdEncrypt"%>
<%@page import="com.yougou.pojo.Users"%>
<%@page import="com.yougou.db.DBHelper"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		String sqlId = "insertOne";
		Connection conn = DBHelper.getConnection();
		Users users = new Users();
		byte[]  usersPwd = UsersPwdEncrypt.pwdEncrypt("123");
		String usersNum = "123456";
		users.setUsersNum(usersNum);
		users.setUsersPwd(usersPwd);
		BaseDao base = new BaseDaoImpl();
		boolean b = base.insertMethod(users, conn, sqlId);
		
		out.print(b); 
	--%>
	
	<%--
		List<Object> list = new ArrayList<>();
		String sqlId = "insertOne";
		Connection conn = DBHelper.getConnection();
		Users users = new Users();
		byte[]  usersPwd = UsersPwdEncrypt.pwdEncrypt("123");
		String usersNum = "123456";
		users.setUsersNum(usersNum);
		users.setUsersPwd(usersPwd);
		
		Users users1 = new Users();
		byte[]  usersPwd1 = UsersPwdEncrypt.pwdEncrypt("123");
		String usersNum1 = "123457";
		users1.setUsersNum(usersNum1);
		users1.setUsersPwd(usersPwd1);
		
		Users users2 = new Users();
		byte[]  usersPwd2 = UsersPwdEncrypt.pwdEncrypt("123");
		String usersNum2 = "123458";
		users2.setUsersNum(usersNum2);
		users2.setUsersPwd(usersPwd2);
		
		list.add(users);
		list.add(users1);
		list.add(users2);
		
		
		BaseDao base = new BaseDaoImpl();
		boolean b = base.insertMoreMethod(list, conn, sqlId);
		
		out.print(b); 
	--%>
	
	<%--
		String sqlId = "selectOne";
		Connection conn = DBHelper.getConnection();
		Users users = new Users();
		String usersNum = "123456";
		users.setUsersNum(usersNum);
		BaseDao base = new BaseDaoImpl();
		Users u = (Users)base.selectMethod(users, conn, sqlId);
		
		out.print(u.getUsersMSum()); 
	--%>
	
		<%--
		String sqlId = "updateOne";
		Connection conn = DBHelper.getConnection();
		Users users = new Users();
		String usersNum = "123456";
		int usersMSum = 1000;
		users.setUsersNum(usersNum);
		users.setUsersMSum(usersMSum);
		BaseDao base = new BaseDaoImpl();
		 boolean  b = base.updateMethod(users, conn, sqlId);
		
		out.print(b); 
		--%>
</body>
</html>