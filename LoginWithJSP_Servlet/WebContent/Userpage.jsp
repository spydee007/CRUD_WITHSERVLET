<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <% Cookie ck[] = request.getCookies(); 
 String msg = ck[0].getName();
request.setAttribute("messageuser", msg);
String m = (String)request.getSession().getAttribute("sessionname");
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<%-- <% out.println("Welcome "+request.getParameter("user")); 
%> --%>
<%-- <%= "Welcome :) "+request.getParameter("pass") %>
<%= "Current time  "+java.util.Calendar.getInstance().getTime() %>
<%= session.getAttribute("sessionname") %> --%>
<!-- 
<jsp:useBean id="obj" class=mypackage.Calc>
</jsp:useBean> -->
<!--  
<%-- <% int m = obj.cube(5); --%>
//  int z = obj.square(4);
 
//   out.println("Cube is "+m);
//   out.println("square is "+z);
<%-- %> --%>
-->
<%-- response.sendRedirect("https://www.google.com"); --%>
</head>
<body>


<%-- <div>Welcome ${messageuser} ${m}</div> --%>
<div>
<!-- <form action="process.jsp">
 Number 1: <input type="text" name="n1" > <br>
 Number 2: <input type="text" name="n2" > <br>
 <input type="submit" value="Divide">
 </form> -->
</div>
<script type="text/javascript">

</script>
</body>
</html>