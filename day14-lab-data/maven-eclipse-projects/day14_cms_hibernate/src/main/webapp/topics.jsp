<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>Customer Login Successful!!!!!</h5>
<%--session.getAttribute("user").getUserDetails().getName() --%>
<h5> Hello , ${sessionScope.user.userDetails.name}</h5>
<h5>All Topics : ${sessionScope.topic.topics}</h5>
</body>
</html>