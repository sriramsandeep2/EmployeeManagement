<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<!-- <link href="mycss.css" rel="stylesheet" type="text/css" /> -->
</head>
<body bgcolor="violet">
<br><br><br>
<h2 align="center">Login</h2>
<form action="Login" method="post">
<table align="center">
<tr><td>Login ID:</td><td><input type="text" name="admin"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
<tr><td></td><td><input type="submit" name="login" value="Login"></td></tr>
</table>
</form>
<form action="ex" method="get">
<input type="submit" name="login" value="Login from India.">
</form>
</body>
</html>