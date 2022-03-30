<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h5 align="center">Your Password : ${requestScope.password}</h5>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login" /></td>
			</tr>

		</table>
	</form>
	<h5 align="center"><a href="<spring:url value='/user/register'/>">Register</a></h5>
	<h5 align="center"><a href="<spring:url value='/user/forget'/>">Forget Password</a></h5>
</body>
</html>