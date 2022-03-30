<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>
		From accept.jsp : Session ID :
		<%=session.getId()%></h5>

	<%
	//out.flush();
	// get request parameters n save it ("user_details") under session scope
	String email = request.getParameter("em");
	String pwd = request.getParameter("pass");
	session.setAttribute("user_details", email + " : " + pwd);
	//redirect the clnt to details page , in the NEXT request
	response.sendRedirect("details.jsp");
	%>
</body>
</html>