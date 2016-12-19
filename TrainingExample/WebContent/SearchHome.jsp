<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.trainingExample.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search-Home</title>
</head>
<body bgcolor="violet">
<div>
<left style="float:left; width: 10%; background-color:yellow;">
<%@include file="left.html" %>
</left>
<right style="float:right; width: 70%;">
<p align="right"><a href="index.jsp">Logout</a></p>
<br><br>
<c:forEach var="e" items="${sessionScope.list}">
<table>
<tr><td>ID:</td><td><c:out value="${e.getId()}"/></td></tr>
<tr><td>First Name:</td><td><c:out value="${e.getfName()}"/></td></tr>
<tr><td>Last Name:</td><td><c:out value="${e.getlName()}"/></td></tr>
<tr><td>Address:</td><td><c:out value="${e.getAddress()}"/></td></tr>
<tr><td>Phone:</td><td><c:out value="${e.getPhone()}"/></td></tr>
<tr><td>Email:</td><td><c:out value="${e.getEmail()}"/></td></tr>
<tr><td>Department:</td><td><c:out value="${e.getDepartment()}"/></td></tr>
<%-- <tr><td>Image:</td><td><c:out value="${sessionScope.image}"/></td></tr> --%>
</table>
<br><br>
</c:forEach>
</right>
</div>
</body>
</html>