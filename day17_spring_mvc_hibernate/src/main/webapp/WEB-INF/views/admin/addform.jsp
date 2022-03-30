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
<h5 style="color: red;"></h5>
<spring:url var="url" value="/admin/add_tutorial"/>
	<form action="${url}" method="get">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter Topic</td>
			
				<td><select name="topicId">
						<c:forEach var="topic" items="${requestScope.topic_list}">

							<option value="${topic.id}">${topic.topicName}</option>
						</c:forEach>

				</select></td>
		
			<tr><td>Name</td><td><input type='text' name='name'></td></tr>
			<tr><td>Author</td><td><input type='text' name='author'></td></tr>
			<tr><td>Publish Date</td><td><input type='date' name='date'></td></tr>
			<tr><td>Contents</td><td><textarea name='content' ></textarea></td></tr>
			<tr><td><input type='submit' value='submit'/></td></tr>
		</table>
	</form>
</body>
</html>