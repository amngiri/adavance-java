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

	<%-- <h5> All tut names ${requestScope.tut_names}</h5> --%>
	<table style="background-color: lightgrey; margin: auto">
		<caption>Tutorials Under Topic ID : ${param.topicId}</caption>
		<c:forEach var="nm" items="${requestScope.tut_names}">
		<tr>
			<td>${nm}</td>
			<td><a href="<spring:url value='/admin/update_form?topicId=${param.topicId}'/>">Update</a></td> 
			<%-- <td><a href="<spring:url value='/admin/update_tutorial'/>">Update</a></td>  --%>
			<td><a href="<spring:url value='/admin/delete_tutorial?tut_name=${nm}&topicId=${param.topicId}'/>">delete</a></td>
		</tr>
		</c:forEach>
		<tr><td><a href="<spring:url value='/admin/add_form?topicId=${param.topicId}'/>">Add Tutorial</a></td></tr>
		<h5>
		<a href="<spring:url value='/user/logout'/>">Log Out</a>
	</h5>
	</table>
</body>
</html>