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
<form:form method="post" modelAttribute="user">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td>User DoB</td>
				<td><form:input type="date" path="dob" /></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><form:select path="role" >
				<form:option value="ADMIN">ADMIN</form:option>
				<form:option value="CUSTOMER">CUSTOMER</form:option>
				 </form:select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>