<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Accessing attributes via EL syntax</h4>
<h5>Page Scoped Attribute:${pageScope.nm1}</h5>
<h5>Request Scoped Attribute:${requestScope.nm2}</h5>
<h5>Session Scoped Attribute:${sessionScope.nm3}</h5>
<h5>Application/context Scoped Attribute: ${applicationScope.nm4}</h5>
</body>
</html>