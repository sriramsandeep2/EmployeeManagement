<%@page import="com.trainingExample.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update view</title>
</head>
<body bgcolor="violet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
<left style="float:left; width: 10%; background-color:yellow;">
<%@include file="left.html" %>
</left>
<right style="float:right; width: 70%;">
<p align="right"><a href="index.jsp">Logout</a></p>
<br><br> 
<form action="Update1" method="post">
<table>
<tr><td>ID:</td><td><input type="hidden" name="id" value="<c:out value="${sessionScope.id}"></c:out>"><c:out value="${sessionScope.id}"></c:out></td></tr>
<tr><td>First Name:</td><td><input type="text" name="fname" value="<c:out value="${sessionScope.fname}"></c:out>"></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="lname" value="<c:out value="${sessionScope.lname}"></c:out>"></td></tr>
<tr><td>Address:</td><td><input type="text" name="address" value="<c:out value="${sessionScope.add}"></c:out>"></td></tr>
<tr><td>Phone:</td><td><input type="text" name="phone" value="<c:out value="${sessionScope.phone}"></c:out>"></td></tr>
<tr><td>Email:</td><td><input type="text" name="email" value="<c:out value="${sessionScope.email}"></c:out>"></td></tr>
<tr><td>Department:</td><td><input type="text" name="depart" value="<c:out value="${sessionScope.dept}"></c:out>"></td></tr>
<tr><td></td><td><input type="submit" value="Update"></td></tr>
</table>
</form>
<% /* idi = ep.getId();
session.setAttribute("idi", idi);
} */%>
</right>
</div>
</body>
</html>