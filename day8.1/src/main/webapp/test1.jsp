<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int result = 100 / 0;// result : method local var : local to _jspService
	//how to create a page scope attribute ? 
			pageContext.setAttribute("nm", 123456);//nm : page scoped attr name
	%>
	<h5>Result : <%=result %></h5>
	<h5>Page Scoped Attribute via EL : ${pageScope.nm}</h5>

</body>
</html>