<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>You have logged out successfully....</h5>
	<h5>
		<a href="index.jsp">Visit Again</a>
	</h5>
	<%
	 session.invalidate();
	%>
</body>
</html>