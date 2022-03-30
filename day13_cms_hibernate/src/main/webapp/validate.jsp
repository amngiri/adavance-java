<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%-- Tell WC to invoke ALL MATCHING setters : req param names MUST MATCH with JB property setters--%>
<jsp:setProperty property="*" name="user"/>
<body>
<%--invoke B.L method of JB : EL syntax n forward the client accordingly--%>
<%--session.getAttribute("user").authenticateUser() --%>
<%-- <h5> Outcome : ${sessionScope.user.authenticateUser()}</h5> --%>
<%--RD rd =request.getRD(....); rd.forward(request,resp); --%>
<%-- <jsp:forward page="${sessionScope.user.authenticateUser()}.jsp"/> --%>
<%--response.sendRedirect(response.encodeRedirecURL(.....)) --%>
<c:redirect url="${sessionScope.user.authenticateUser()}.jsp"/>
</body>
</html>