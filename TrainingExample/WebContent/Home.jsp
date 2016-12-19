<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<%
/* String admin = request.getParameter("admin");
if(admin == null){
	out.println("<p align=center>Please login first.</p>");
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
} */
%>
<body bgcolor="violet">
<div>
<left style="float:left; width: 10%; background-color:yellow;">
<%@include file="left.jsp" %>
</left>
<right style="float:right; width: 90%;">
<p align="right"><a href="index.jsp">Logout</a></p>
<h2 align="center">Welcome to my project<br><br><br>
Select One option from left menu</h2>
</right>
</div>
</body>
</html>