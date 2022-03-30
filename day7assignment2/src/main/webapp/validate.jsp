<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="pojo.User" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!
HashMap<String,User> map =new HashMap<>();
public void jspInit()
{
	 
	map.put("Aman",new User("Aman","aman",21));
	map.put("Amit", new User("Amit","amit",28));
    User userpass=map.get("Aman");
  
}%>
<body>
    <%
    String name=request.getParameter("nm");
    String pass=request.getParameter("pass");
    User user=map.get(name);
    if(user.getName().equals(name) && user.getPassword().equals(pass))
    {
    	request.setAttribute("user_details", user);
    	RequestDispatcher rd=request.getRequestDispatcher("detail.jsp");
    	rd.forward(request, response);
    }
    else
    {
    	out.write("<h2>Invalid login <a href= 'index.jsp'>Login again</a></h2>");
    }
    %>
</body>
</html>