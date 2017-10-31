package com.bridgeit.controller;

import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.dao.dbConnection;

@WebServlet("/info")
public class info extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i=0;
		try {
			
			Connection connection=dbConnection.getConnection();
			PreparedStatement statement=connection.prepareStatement("insert into registration values(?,?,?,?)");
			statement.setString(1, request.getParameter("userName"));
			statement.setString(2, request.getParameter("email"));
			statement.setString(3, request.getParameter("password"));
			statement.setString(4, request.getParameter("number"));
			i=statement.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
