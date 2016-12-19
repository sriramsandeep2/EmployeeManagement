<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
<script type="text/javascript">
function ValidateEmail()  
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
if(document.form.email.value.match(mailformat))
	return false;
else
	return true;   
}
function vali(){
	var num = /^[0-9]+$/;
	var p_len = document.form.phone.value.length;
if (document.form.fname.value.match(num)) {
    document.getElementById('fname').innerHTML="Please enter valid First Name!";
    document.form.fname.focus();
    return false;
}
if (document.form.lname.value.match(num)) {
    document.getElementById('lname').innerHTML="Please enter valid Last Name!";
    document.form.lname.focus();
    return false;
}
if (document.form.address.value.match(num)) {
    document.getElementById('addr').innerHTML="Please enter valid Address!";
    document.form.address.focus();
    return false;
}
if (document.form.depart.value.match(num)) {
    document.getElementById('depart').innerHTML="Please enter valid Department!";
    document.form.depart.focus();
    return false;
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
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter any/all fields to search<p>
<form action="Search" method="post" onsubmit=" return vali();" name="form">
<table>
<tr><td>First Name:</td><td><input type="text" name="fname"></td><td id="fname" style="color:red;"></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="lname"></td><td id="lname" style="color:red;"></td></tr>
<tr><td>Address:</td><td><input type="text" name="address"></td><td id="addr" style="color:red;"></td></tr>
<tr><td>Phone:</td><td><input type="text" name="phone"></td><td id="phone" style="color:red;"></td></tr>
<tr><td>Email:</td><td><input type="text" name="email"></td><td id="email" style="color:red;"></td></tr>
<tr><td>Department:</td><td><input type="text" name="depart"></td><td id="depart" style="color:red;"></td></tr>
<tr><td></td><td><input type="submit" value="Search"></td></tr>
</table>
</form>
</right>
</div>
</body>
</html>