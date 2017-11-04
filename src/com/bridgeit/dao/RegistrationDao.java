package com.bridgeit.dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bridgeit.model.User;
 public class RegistrationDao {
	
	 /**
	 * @param user
	 * Checking user already exist with given email_id
	 * @return true if user not exist,else false
	 */
	public boolean emailValidate(User user) {
			boolean status=true;
			try {
				Connection connection=dbConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement("select * from registration where email=?");
				statement.setString(1, user.getEmail());		
				ResultSet result=statement.executeQuery();
				
				if(result.next()) {
					status=false;
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
			return status;
		}

	 
	 
	/**
	 * @param user
	 * 
	 * @return true if registration successful,else false
	 */
	public boolean registrationValidate(User user) {
		

		boolean status=false;
		try {
			Connection connection=dbConnection.getConnection();
			PreparedStatement statement=connection.prepareStatement("insert into registration values(?,?,?,?)");

			statement.setString(1, user.getUserName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setLong(4, user.getNumber());
			
			int result=statement.executeUpdate();
			
			if(result>0) {
				status=true;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	}
