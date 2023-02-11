

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Form</title>
</head>
<h4>Login form </h4>
<body>
<%= request.getAttribute("errorMessage") %>
<form action="LoginServlet" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name"><br><br>
<label for="password">Password:</label>
<input type="password" id="password" name="password"><br><br>

  <input type="submit" value="Submit" >
 

  
</form> 

</body>
</html>