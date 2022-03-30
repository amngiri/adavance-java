<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4 style="background-color: red" align="center"></h4>
	<form action="validate.jsp" method="get">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter User name</td>
				<td><input type="text" name="nm" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="pass" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>