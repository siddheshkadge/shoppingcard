<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="com.Books.Product"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>Library Books</title>
</head>
<body>


	<%
	int i = 1;
		List<Product> list = (List<Product>) request.getAttribute("bookList");
	%>

	<%
	for (Product u : list) {
	%>
	<tr>
		<td><%=i%></td>
		<td><%=u.getBookName()%></td>
		<td><%=u.getPrice()%></td>
		<br>

	</tr>
	<%
	}
	%>


</body>
</html>