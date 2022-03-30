<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>Hello , ${requestScope.user_details.name} , Login Successful !</h5>
<h5>All Topics : ${requestScope.topic_list}</h5>
</body>
</html>