<%@page import="pojos.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!HashMap<String, User> users;

	public void jspInit() {
		users = new HashMap<>();
		users.put("Rama", new User("Rama", "1234", 30));
		users.put("Riya", new User("Riya", "3234", 25));
		users.put("Mihir", new User("Mihir", "4234", 35));
	}%>
<body>
	<%
	//validation logic
	String userName = request.getParameter("name");
	String pwd = request.getParameter("pass");
	User validUser = users.get(userName);
	if (validUser != null) {
		//chk pwd
		if (validUser.getPassword().equals(pwd)) {
			//login success : store user details in a suitable scope : CP2 (redirect)
			session.setAttribute("user_details", validUser);
			//encode redirect URL n then invoke send redirect
			response.sendRedirect(response.encodeRedirectURL("details.jsp"));
		} else {
	%>
	<h5>
		Invalid Password ... Do you want to <a href="login.jsp">Retry ?</a>
	</h5>
	<%
	}
	%>
	<%
	} else {
	%>
	<h5>
		Invalid User name ... Do you want to <a href="register.jsp">Register?</a>
	</h5>
	<%
	}
	%>
</body>
</html>