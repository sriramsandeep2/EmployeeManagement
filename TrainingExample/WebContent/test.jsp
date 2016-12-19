<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<script type="text/javascript">
function ValidateEmail()  
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
if(document.form.email.value.match(mailformat))
	return false;
else
	return true;   
}
function val(){
	var num = /^[0-9]+$/;
	var p_len = document.form.phone.value.length;
if (document.form.fname.value == "" || document.form.fname.value.match(num)) {
    document.getElementById('fname').innerHTML="Please enter valid First Name!";
    document.form.fname.focus();
    return false;
}
else{
	document.getElementById('fname').innerHTML="";
}
if (document.form.lname.value == "" || document.form.fname.value.match(num)) {
    document.getElementById('lname').innerHTML="Please enter valid Last Name!";
    document.form.lname.focus();
    return false;
}
else{
	document.getElementById('lname').innerHTML="";
}
if (document.form.address.value == "") {
    document.getElementById('addr').innerHTML="Please enter valid Address!";
    document.form.address.focus();
    return false;
}
else{
	document.getElementById('addr').innerHTML="";
}
if (document.form.phone.value == "" || p_len != 10) {
    document.getElementById('phone').innerHTML="Please enter valid Phone number!";
    document.form.phone.focus();
    return false;
}
else{
	document.getElementById('phone').innerHTML="";
}
if (document.form.email.value == "" || ValidateEmail()) {
    document.getElementById('email').innerHTML="Please enter valid Email Id!";
    document.form.email.focus();
    return false;
}
else{
	document.getElementById('email').innerHTML="";
}
if (document.form.depart.value == "" || document.form.depart.value.match(num)) {
    document.getElementById('depart').innerHTML="Please enter valid Department!";
    document.form.depart.focus();
    return false;
}
else{
	document.getElementById('depart').innerHTML="";
}

}
</script>
</head>
<body bgcolor="violet">
<div>
<left style="float:left; width: 10%; background-color:yellow;">
<%@include file="left.jsp" %>
</left>
<right style="float:right; width: 70%;">
<p align="right"><a href="index.jsp">Logout</a></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter all fields to register<p>
<form action="Register" method="post"" name="form" enctype="multipart/form-data">
<table>
<tr><td>First Name:</td><td><input type="text" name="fname"></td><td id="fname" style="color:red;"></td></tr>
<tr><td>Image:</td><td><input type="file" name="image" accept=".jpg"></td><td id="depart" style="color:red;"></td></tr>
<tr><td>File:</td><td><input type="file" name="pdf" size="1"></td><td id="depart" style="color:red;"></td></tr>
<tr><td></td><td><input type="submit" value="Register" onclick="alert('Click Okay to Register');"></td></tr>
</table>
</form>
</right>
</div>
</body>
</html>