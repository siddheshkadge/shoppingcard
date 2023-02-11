<% %>@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Library</title>
</head>
<body>
  
  <sql:setDataSource driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/office" user="root"
   password="root" var="ds" ></sql:setDataSource>
    
    <sql:query dataSource="${ds}" var="rs" >select * from emp;</sql:query>
   
   <table>
        <tr>
        <td>ID</td>
        <td>Name</td>
        <td>designation</td>
        </tr>
        <c:forEach items="${rs.rows}" var="row">
        <tr>
         <tr><c:out value="${row.id}"></c:out>
        <tr><c:out value="${row.name}"></c:out>
         <tr><c:out value="${row.designation}"></c:out>
        
        </tr>
        
        
        </c:forEach>
   </table>
</body>
</html>