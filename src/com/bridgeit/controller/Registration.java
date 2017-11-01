package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.dao.dbConnection;
import com.bridgeit.model.User;
@WebServlet("/Registration")
public class Registration extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	User user=new User();
	PrintWriter writer=response.getWriter();
	user.setUserName(request.getParameter("userName"));
	user.setEmail(request.getParameter("email"));
	user.setPassword(request.getParameter("password"));
	int number=Integer.parseInt(request.getParameter("number"));
	user.setNumber(number);
	try{
		Connection connection=dbConnection.getConnection();
		PreparedStatement statement=connection.prepareStatement("insert into registration values(?,?,?,?)");

		statement.setString(1, user.getUserName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getPassword());
		statement.setInt(4, user.getNumber());
		
		int i=statement.executeUpdate();
		if(i>0){
		
	
			request.setAttribute("details", "Registration Successfull");
			RequestDispatcher requst=request.getRequestDispatcher("index.jsp");
			requst.include(request, response);
		}else{
		
			request.setAttribute("details", "User Already Exist With This Name..");
			
			RequestDispatcher requst=request.getRequestDispatcher("index.jsp");
			requst.include(request, response);
			
		}
	}catch(Exception e){
		System.out.println(e);
	}
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
