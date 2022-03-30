<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="background-color: lightgrey; margin: auto">
	<a href="/admin/list_of_advt"> Product List..................</a>
		<tr>
		
			<th>Product</th>
			<th>Brand</th>
			<th>telecastDate</th>
			<th>Status</th>
		</tr>
		<c:forEach var="c" items="${requestScope.advt_list}">
			<tr>
			
				<td>${c.product}</td>
				<td>${c.brand}</td>
				<td>${c.telecastDate}</td>
				<td>${c.status}</td>
			</tr>
		</c:forEach>
		<tr>
		<td><a href="<spring:url value='/admin/addproduct'/>">Add new product</a>
		</td>
		</tr>
	</table>
</body>
</html>