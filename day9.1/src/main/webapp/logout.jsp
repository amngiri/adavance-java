<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Hello , ${sessionScope.user.userDetails.name}</h5>
	<h5>${sessionScope.tutorial.message}</h5>
	<%--clean up user , topic tut dao --%>
	${sessionScope.user.userDao.cleanUp()}
	${sessionScope.topic.topicDao.cleanUp()}
	${sessionScope.tutorial.tutDao.cleanUp()}
	<%--invalidate session --%>
	${pageContext.session.invalidate()}
	<h5>You have logged out...</h5>
	<h5>
		<a href="login.jsp">Visit Again</a>
	</h5>
</body>
</html>