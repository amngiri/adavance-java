<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--importing spring supplied JSP Tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>  
</head>
<body>
	<h5>Hello , ${sessionScope.user_details.name} , Login Successful !</h5>
	<%-- <h5>All Topics : ${requestScope.topic_list}</h5> --%>
	<spring:url var="url" value="/customer/tutorials"/>
	<form action="${url}" method="get">
		<table style="background-color: lightgrey; margin: auto">
			<%-- <c:forEach var="topic" items="${requestScope.topic_list}"> --%>
				<tr>
					<td><input type="radio" name="topicId" value="1" />Buy Ready To Eat Food</td>
					<td><input type="radio" name="topicId" value="2" />By Vegetable</td>
					<td><input type="radio" name="topicId" value="3" />By Grocery</td>
				</tr>
			<%-- </c:forEach> --%>
			<tr>
				<td><input type="submit" value="Choose Topic" /></td>
			</tr>
		</table>
	</form>

</body>
</html>