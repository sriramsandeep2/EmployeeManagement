
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All</title>
<script type="text/javascript">
function vald() {
	var id_len = document.form.id.value.length;
	if (document.form.id.value == "" || id_len > 2) {
	    document.getElementById('id').innerHTML="Please enter valid ID!";
	    document.form.id.focus();
	    return false;
	}
	else{
		document.getElementById('id').innerHTML="";
	}

}
</script>
</head>
<body bgcolor="violet">
<div>
<left style="float:left; width: 10%; background-color:yellow;">
<%@include file="left.html" %>
</left>
<right style="float:right; width: 70%;">
<p align="right"><a href="index.jsp">Logout</a></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login to view all employees<p>
<form action="ViewAll.do" method="get" onsubmit=" return vald();" name="form">
<table>
<tr><td>Login ID:</td><td><input type="text" name="admin" value="admin"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password" value="password"></td></tr>
<tr><td></td><td><input type="submit" name="login" value="Login"></td></tr>
</table>
</form>
</right>
</div>
</body>
</html>