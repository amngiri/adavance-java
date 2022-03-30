<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Admin Login Successful!!!!!</h5>
	<%--session.getAttribute("user").getUserDetails().getName() --%>
	<h5>Hello , ${sessionScope.user.userDetails.name}</h5>
	<%-- <h5>All topics : ${sessionScope.topic.topics}</h5> --%>
	<form action="process_form.jsp" method="get">
		<table style="background-color: lightgrey; margin: auto">
			<caption>Add New Tutorial</caption>
			<tr>
				<td>Topic</td>
				<td><select name="topicId">
						<c:forEach var="t" items="${sessionScope.topic.topics}">
							<option value="${t.topicId}">${t.topicName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="tutName" /></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><input type="text" name="author" /></td>
			</tr>
			<tr>
				<td>Publish Date</td>
				<td><input type=date name="pubDate" /></td>
			</tr>
			<tr>
				<td>Contents</td>
				<td><textarea rows="10" cols="40" name="contents"></textarea>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add New Tutorial" /></td>
			</tr>

		</table>
	</form>
</body>
</html>