<%@page import="java.util.ArrayList"%>
<%@page import="com.weblogic.tutorial.logic.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Date" %>


	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Contact> contacts = (List<Contact>)request.getAttribute("contacts");
		for (Contact cont : contacts) {
			out.println( "<form action='DeleteContact' method='POST'>" +
						 cont.getName() +" <input type='submit' value='Delete contactc' />" +
						 "<input type='hidden' name='key' value='" + cont.getMail() + "' />" +
						 "</form>");
			out.println("<br />");		
		}
	%>
	
	<form action="addContact.jsp" method="GET">
		<input type="submit" value="Add Contact" />
	</form>
</body>
</html>