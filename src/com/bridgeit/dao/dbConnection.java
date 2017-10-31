package com.bridgeit.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
	static Connection connection = null;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer", "root", "manoj");

		} catch (Exception e) {
			System.out.print(e);
		}
		return connection;

	}
}