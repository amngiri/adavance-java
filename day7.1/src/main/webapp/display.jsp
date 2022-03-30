<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 style="background-color: red" align="center">
		Session ID :
		<%=session.getId()%></h4>
	<h4>Version 1</h4>
	<%
	//JSP scripting element : scriptlet
	out.write("<h5> Email :" + request.getParameter("em") + "</h5>");
	out.write("<h5> Password :" + request.getParameter("pass") + "</h5>");
	%>
	<h4>Version 2</h4>
	<h5>
		Email :
		<%
	//JSP scripting element : scriptlet
	out.write(request.getParameter("em"));
	%>
	</h5>
	<h5>
		Password :
		<%
	//JSP scripting element : scriptlet
	out.write(request.getParameter("pass"));
	%>
	</h5>
	<hr />
	<h5>User Details via JSP Expression</h5>
	<h5>
		Email :
		<%=request.getParameter("em")%></h5>
	<h5>
		Password :
		<%=request.getParameter("pass")%></h5>
	<hr />
	<h5>User Details via EL syntax</h5>
	<h5>param : ${param}</h5>
	<h5>Email : ${param.em}</h5>
	<h5>Password  : ${param.pass}</h5>
	<h5>
		<a href="logout.jsp">Log Me Out</a>
	</h5>

</body>
</html>