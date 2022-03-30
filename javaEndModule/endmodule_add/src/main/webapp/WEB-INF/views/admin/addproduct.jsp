<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="advertisement">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Product</td>
				<td><form:input path="product" /></td>
			</tr>
			<tr>
				<td>brand</td>
				<td><form:input path="brand" /></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><form:input type="date" path="telecastDate" /></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><form:select path="status" >
				<form:option value="Rejected">Rejected</form:option>
				<form:option value="Accepted">Accepted</form:option>
				 </form:select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>


