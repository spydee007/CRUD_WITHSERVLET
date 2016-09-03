<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
 <%@   page  import="com.eclipse.mypack.RegisterDAO"  %>
 <jsp:useBean id="regbean" class="com.eclipse.mypack.Register"></jsp:useBean>
<jsp:setProperty property="*" name="regbean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<%--  <jsp:setProperty property="userName" name="regbean" value= <% request.getParameter("username"); %> /> --%>
<%--   <jsp:setProperty property="userPass" name="regbean" value=<% request.getParameter("userpass"); %> /> --%>
<%--    <jsp:setProperty property="userEmail" name="regbean" value=<% request.getParameter("useremail"); %> />/> --%>
<%--     <jsp:setProperty property="userAddress" name="regbean" value=<% request.getParameter("useraddress"); %> />/> --%>

<%
int status = RegisterDAO.RegisterUser(regbean);
if (status > 0){ 
	out.println("User registered successfully");
}
else{
	out.println("Cannot register user please try again!");
}
%>
<jsp:include page="index.jsp"></jsp:include>
</body>
</html>