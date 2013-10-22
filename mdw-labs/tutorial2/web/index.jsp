<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World!</title>
</head>
<body>
<%= request.getRemoteUser() %> <br />
	Last servlet 
	<%
		String lastServlet = (String)session.getAttribute("lastServlet");
		if (lastServlet == null)
		  	out.println("No servlet accessed");
		else
			out.println("<a href='" + lastServlet + "'>Here is the last servlet</a>");
	%>
	<br />
    <%
    	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
		Date date = new Date();
		out.println(dateFormat.format(date));
    %>
</body>
</html>
