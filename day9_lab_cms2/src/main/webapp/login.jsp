<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--Tell WC to create User Bean instance (attribute) n add it under session scope --%>
<jsp:useBean id="user" class="beans.UserBean" scope="session" />
<%--create topic bean instance n add it under the session scope --%>
<jsp:useBean id="topic" class="beans.TopicBean" scope="session" />
<body>
	<%--session.getAttribute("user").getErrMesg() --- sent to clnt --%>
	<h5 style="color: red;">${sessionScope.user.errMesg}</h5>
	<form action="validate.jsp" method="post">
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
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>