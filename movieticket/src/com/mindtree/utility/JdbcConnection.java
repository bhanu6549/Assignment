package com.mindtree.utility;

import java.sql.DriverManager;


import java.sql.Connection;

public class JdbcConnection {
	private static final String url = "jdbc:mysql://localhost:3306/booking";
	private static final String uname = "root";
	private static final String pass = "Welcome123";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, pass);
			System.out.println("success");

		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	public static String closeConnection(Connection connection) {
		String result = "";
		try {
			connection.close();

		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

}
