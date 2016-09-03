<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    errorPage="error.jsp"
%>
<%
String num1 = request.getParameter("n1");
String num2 = request.getParameter("n2");

int a = Integer.parseInt(num1);
int b = Integer.parseInt(num2);
int c = a/b;
%>
<%= "Division of "+a+" with "+b+"  is"+c %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Process Page</title>
</head>
<body>

<!--<jsp:forward page="test.jsp">
<jsp:param value="n1" name="num1"/>
<jsp:param value="n2" name="num2"/>
</jsp:forward>
-->
</body>
</html>