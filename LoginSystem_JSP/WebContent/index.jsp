<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home |</title>
</head>
<body>
<script type="text/javascript">
function validateRegister()
{
//  var name = document.getElementById("userName");
//  var pass = document.getElementById("userPass");
//  var email = document.getElementById("userEmail");
//  var add = document.getElementById("userAddress");

 if (document.getElementById("userName")==null || document.getElementById("userName")=="")
	 {
		alert("User name cannot be blank");
		document.getElementById("userName").focus();
		return false;
	 }

 if (pass==null || pass=="")
 {
	alert("Password cannot be blank");
	document.getElementById("userPass").focus();
	return false;
 }

 if (email==null || email=="" )
 {
	alert("Email id cannot be blank");
	document.getElementById("userEmail").focus();
	return false;
 }

 if (add==null || add=="")
 {
	alert("Address cannot be blank");
	document.getElementById("userAddress").focus();
	return false;
 }
}
</script>
<div>
<form action="process.jsp" onsubmit="return validateRegister()" method="post">
<table> 
	<tbody>
		<tr>
			<td>User name</td>
			<td><input type="text" name="userName" id="userName"></td>
		</tr>
		<tr>
			<td>Email id</td>
			<td><input type="text" name="userEmail" id="userEmail"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="userPass" id="userPass"></td>
		</tr>
		<tr>
			<td>Country</td>
			<td>
			<select name="userAddress" id ="userAddress" >
			<option selected> Maharashtra </option>
			<option> Madhya Pradesh </option>
			<option> Karnataka </option>
			<option> Tamil Nadu</option>
			<option> Delhi</option>
			<option> Andra Pradesh </option>
			<option> Haryana </option>
			<option> Gujarat </option>
			<option> Rajashtan </option>
			</select>
			</td>
		</tr>
		
		<tr> 
			<td><input type="submit"  value="Register"></td>
			<td><input type="reset" value="Clear"></td>
		</tr>
	</tbody>
</table>
</form>
</div>
</body>
</html>