<%@page import="java.util.Properties"%>
<%@page import="com.yougou.util.UsersPwdEncrypt"%>
<%@page import="com.yougou.db.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	你好优购！
	<%
		UsersPwdEncrypt.pwdEncrypt("");
	%>
</body>
</html>