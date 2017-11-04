package com.bridgeit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.dao.dbConnection;

/**
 * Servlet implementation class AjaxEmailValidation
 */
@WebServlet("/AjaxEmailValidation")
public class AjaxEmailValidation extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		System.out.println(email);
		try {
			Connection connection=dbConnection.getConnection();
			PreparedStatement statement=connection.prepareStatement("select * from registration where email=?");
			statement.setString(1, email);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				response.getWriter().write("* This email already registered with us...");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
