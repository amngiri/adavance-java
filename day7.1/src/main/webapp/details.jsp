<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5> From <%= page  %> :  Session ID : <%= session.getId() %></h5>
<h5>User Details retrieved from Session Scope : ${sessionScope.user_details}</h5>
</body>
</html>