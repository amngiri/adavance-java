<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Login Successful</h5>
	<h5>Validated User Details : ${sessionScope.user_details}</h5>
	<%
	 String url=response.encodeURL("logout.jsp");
	%>
	<h5>
		<a href="<%= url %>">Log Me Out</a>
	</h5>
</body>
</html>