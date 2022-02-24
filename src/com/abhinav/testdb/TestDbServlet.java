package com.abhinav.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Set Up Connection variable
		String jdbcURL="jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSl=false&serverTimezone=UTC";
		String user="hbstudent";
		String password="hbstudent";
		String driver="com.mysql.jdbc.Driver";
		
		//Get connection to database 
		
		try {

			PrintWriter out =response.getWriter();
			out.println("Connecting to database : "+jdbcURL);
			
			Class.forName(driver);
			Connection myConn=DriverManager.getConnection(jdbcURL, user, password);
		    
			out.println("Success!");
			myConn.close();
		
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		
		System.out.println("Connection successfull");
	
	}


}
