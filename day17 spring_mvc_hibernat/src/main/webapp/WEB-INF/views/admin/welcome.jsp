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
	<h5>Hello , ${sessionScope.user_details.name} , Login Successful !</h5>
	<spring:url var="url" value="/admin/tutorials" />
	<form action="${url}" method="get">
		<table style="background-color: lightgrey; margin: auto">

			<tr>
				<td><select name="topicId">
						<c:forEach var="topic" items="${requestScope.topic_list}">

							<option value="${topic.id}">${topic.topicName}</option>
						</c:forEach>

				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Choose Topic" /></td>
			</tr>
		</table>
	</form>

</body>
</html>