<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 align="center">JSP Implicit Objects</h5>
	<h5>Page : <%= page %></h5>
	<h5>PageContext : <%= pageContext %></h5>
	<h5>Request : <%= request %></h5>
	<h5>Session  : <%= session %></h5>
	<%-- <h5>Exception : <%= exception %></h5> --%>
</body>
</html>