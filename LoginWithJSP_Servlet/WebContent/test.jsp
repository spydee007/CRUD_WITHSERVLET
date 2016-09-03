<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Page</title>
</head>
<body>
<%= request.getParameter("n1")  %>
<%= request.getParameter("n2")  %>
<h3> This is Start of Test JSP</h3>
<!--<jsp:include page="process.jsp">


</jsp:include>
---->


<h3> This is End of Test JSP</h3>
</body>
</html>