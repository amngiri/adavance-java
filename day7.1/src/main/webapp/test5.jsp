<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
//add an attrbute under the curr page scope
pageContext.setAttribute("nm1", 1234);//String obj
//add an attrbute under the curr request scope
request.setAttribute("nm2", 1235);//String obj
//add an attrbute under the curr session scope
session.setAttribute("nm3", 1236);//String obj
//add an attrbute under the curr web app scope
application.setAttribute("nm4", 1237);//String obj
//response.sendRedirect("test6.jsp");
RequestDispatcher rd=request.getRequestDispatcher("test6.jsp");
rd.forward(request, response);

%>
</body>
</html>