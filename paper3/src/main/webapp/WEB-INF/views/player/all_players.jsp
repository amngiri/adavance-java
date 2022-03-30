<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h5>Welcome, ${requestScope.user_details.name}</h5>
	<table border="auto" style="background: lightgray;">
		<c:forEach var="list" items="${requestScope.list}">
			<tr>
				<td>${list.playerName}</td>
				<td>${list.teamName}</td>
				<td>${list.role}</td>
				<td>${list.stats}</td>
				<td>${list.matches}</td>
				<td><a href="<spring:url value='/player/delete?id=${list.id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td><a href="<spring:url value='/player/addplayer'/>">Add New
					Player</a></td>
		</tr>
	</table>

</body>
</html>


