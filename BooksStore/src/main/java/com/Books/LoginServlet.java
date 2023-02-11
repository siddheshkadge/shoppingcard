package com.Books;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		
		HttpSession session=request.getSession();
		String username1=(String) session.getAttribute(username);
		String password1=(String) session.getAttribute(password);
		
		System.out.println("username" +username1 +"password "+password1);
		
		if(username.equals(username1) && (password.equals(password1)))
		{
			request.setAttribute("bookList", getBookList());
			request.getRequestDispatcher("Library.jsp").forward(request, response);
			
		}
		else
		{
			request.setAttribute("eror massage", "invalid username password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	
	
	  public List getBookList()
	 {
		 List l=new ArrayList();
		 BooksPoint b=new BooksPoint();
		 b.setBookName("classmate");
		 b.setPrice(100);
		 BooksPoint b1=new BooksPoint();
		 b.setBookName("marathi");
		 b.setPrice(150);
		 BooksPoint b2=new BooksPoint();
		 b.setBookName("English");
		 b.setPrice(200);
		 l.add(b);
		 l.add(b1);
		 l.add(b2);
				 
		return null;
		 
	 }*/
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name=request.getParameter("name");
		 String password=request.getParameter("password");
	
		 RequestDispatcher dispatcher=null;
		 try { 
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","root");
			  PreparedStatement pst=con.prepareStatement("select * from ragestration where name= ? and password=?");
			  pst.setString(1, name);
			  pst.setString(2, password);
			  
		ResultSet rs=pst.executeQuery();
		List<Product> books=new ArrayList<Product>();
			  if(rs.next()) {
				 
				  PreparedStatement pst1=con.prepareStatement("select * from books");
				  ResultSet rs1=pst1.executeQuery();
				  
				  while(rs1.next())
				  {
					  Product b=new Product();
					  b.setBookName(rs1.getString(1));
					  b.setPrice(rs1.getDouble(2));
					  books.add(b);
					  
				  }
				 System.out.println(books);
				 request.setAttribute("bookList", books);
				 dispatcher =request.getRequestDispatcher("Library.jsp");
			  }
			  else {
				  request.setAttribute("stetus", "failed");
				  dispatcher =request.getRequestDispatcher("login.jsp");
			  }
			  dispatcher.forward(request, response);
		 } 
		 catch(Exception e){
			 e.printStackTrace();
		 }

  	}
}	 