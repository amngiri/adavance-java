<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!String mesg = "test mesg....";//instance var.%>
<body>
	<%
	//method local var : within _jspService
	String anotherMesg = "something else!";
	//create page scoped attribute
	pageContext.setAttribute("nm", 123456);
	%>
	<%@ include file="test3.jsp"%>
</body>
</html>