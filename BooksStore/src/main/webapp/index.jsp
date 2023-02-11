<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration form</title>
</head>
<h1>Registration form</h1>
<body>
<form action="ragestration" method="post">
    <label>Name:</label>
    <input type="text" name="name" required >
    <br>
    <br>
    <label>Password:</label>
    <input type="password" name="password" required>
    <br>
    <br>
    <label>Email:</label>
    <input type="email" name="email" required>
    <br>
    <br>
    <label>City:</label>
    <input type="text" name="city" required>
    <br>
    <br>
    <input type="submit" value="Register">
   
    <a href="login.jsp">login</a>
    
</form>

</body>
</html>