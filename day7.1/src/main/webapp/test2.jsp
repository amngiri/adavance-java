<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	int counter;
	String mesg = "some mesg!!!!!";

	//can you override jsp life cycle methods from here ? YES
	public void jspInit() {
		System.out.println("in jsp init");
		counter = 100;
	}

	//can you add your own methods ?
	int increment() {
		counter++;
		return counter;
	}%>


<body>
	<h5>
		Visits :
		<%=increment()%></h5>
	<h5>
		<a href="test3.jsp">Next</a>
	</h5>
</body>
<%!public void jspDestroy() {
		System.out.println("in jsp destroy");

	}%>

</html>