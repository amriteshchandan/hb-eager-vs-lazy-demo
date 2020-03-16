package com.amritesh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("connecting to db" + jdbcURL);
			Connection connection = DriverManager.getConnection(jdbcURL, user, password);
			if (connection != null)
				System.out.println("connection successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}