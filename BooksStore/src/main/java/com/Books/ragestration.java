package com.Books;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;   

public class ragestration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	

/*	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		System.out.println("username =" + username + "  password =" + password + " email = " + email + "city  =" + city);
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
		dispatcher.forward(request, response);
	}
}*/

protected void doPost(HttpServletRequest request, HttpServletResponse
 response) throws ServletException, IOException {

String name = request.getParameter("name"); 
String password =request.getParameter("password");
String email = request.getParameter("email"); 
String city = request.getParameter("city");

 RequestDispatcher dispatcher=null;

 try { Class.forName("com.mysql.cj.jdbc.Driver"); Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","root");
 PreparedStatement pst=con. prepareStatement("insert into ragestration(name,password,email,city)values(?,?,?,?)");
 pst.setString(1, name); 
 pst.setString(2, password);
 pst.setString(3,email);
 pst.setString(4, city);

 int rowCount =pst.executeUpdate(); 
 dispatcher=request.getRequestDispatcher("success.jsp"); 
 if(rowCount>0) {
 request.setAttribute("status", "success");

 } else { request.setAttribute("Status ", "failed"); }

 dispatcher.forward(request, response); }
 catch (Exception e)
 {
 e.printStackTrace();
 }
}
}
