<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Thanks ${requestScope.user_details.name}
<a href="index.jsp">Visit Again</a>
</h4>
<%session.invalidate();%>
</body>
</html>