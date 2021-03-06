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
import com.bridgeit.service.ServiceImp;
import com.bridgeit.dao.RegistrationDao;
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
ServiceImp service=new ServiceImp();
User user=new User();


	user.setUserName(request.getParameter("userName"));
	user.setEmail(request.getParameter("email"));
	user.setPassword(request.getParameter("password"));
	long number=Long.parseLong(request.getParameter("number"));
	user.setNumber(number);

	if(service.serviceEmailValidate(user)) {
		
	
	if(service.seviceRegistrationValidate(user)){
			request.setAttribute("details", "Registration Successfull...");
			RequestDispatcher requst=request.getRequestDispatcher("index.jsp");
			requst.include(request, response);
		}else{
		
			request.setAttribute("details","Registration Failed...");
			
			RequestDispatcher requst=request.getRequestDispatcher("index.jsp");
			requst.include(request, response);
			
		}
	
	}else {
		request.setAttribute("details", "User Already Exist With This email..");
		
		RequestDispatcher requst=request.getRequestDispatcher("index.jsp");
		requst.include(request, response);
	}
	
	}
/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
*/
}
