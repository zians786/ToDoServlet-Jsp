package com.bridgeit.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bridgeit.model.User;

public class LoginDao {

		/**
		 * @param user
		 * validate user by checking Username and Password
		 * @return true if user exist,else false
		 */
		public boolean validate(User user) {
		boolean status=false;
		try {
			Connection connection=dbConnection.getConnection();
			PreparedStatement statement=connection.prepareStatement("select * from registration where username=? and password=?");
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			
			ResultSet result=statement.executeQuery();
			
			if(result.next()) {
				status=true;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
		
	
}
