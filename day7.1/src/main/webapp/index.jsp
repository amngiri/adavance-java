<%@ page import="java.util.Date"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4 style="background-color: red" align="center">Session ID : <%= session.getId() %></h4>
	<h5>
		Welcome 2 JSP !!!!!! ,
		<%=new Date()%></h5>
	<h5>
		<a href="comments.jsp">Testing Comments</a>
	</h5>
	<h5>
		<a href="login.jsp">Testing Scriptlets</a>
	</h5>
	<h5>
		<a href="test1.jsp">Testing JSP Implicit Objects</a>
	</h5>
	<h5>
		<a href="login2.jsp">Testing EL Syntax</a>
	</h5>
	<h5>
		<a href="test2.jsp">Testing JSP Declarations</a>
	</h5>
	<h5>
		<a href="test4.jsp">Testing Error Handling in JSP</a>
	</h5>
	<h5>
		<a href="test5.jsp">Testing Scope in JSP</a>
	</h5>
</body>
</html>