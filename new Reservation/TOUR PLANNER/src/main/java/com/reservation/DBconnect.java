package com.reservation;

import java.sql.Connection;

import java.sql.DriverManager;

public class DBconnect {
	
	private static final String URL = "jdbc:mysql://localhost:3306/mydb";
	private static final String USER = "root";
	private static final String PASSWORD = "Kaushalya02@";

	private static Connection con;

	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			System.out.println("DB Connection Error");
		}
		return con;
	}

}
