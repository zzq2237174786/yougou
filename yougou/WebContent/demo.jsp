<%@page import="com.yougou.util.JsonSuccess"%>
<%@page import="com.yougou.service.zzq.impl.BaseServcieImpl"%>
<%@page import="com.yougou.service.zzq.BaseService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BaseService bs = new BaseServcieImpl();
		String data = bs.getNavClassify();
		data = JsonSuccess.success(data);
		out.print(data);
	%>
</body>
</html>