package com.mindtree.collageServay.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButility {
	final static String driverclass = "com.mysql.cj.jdbc.Driver";
	final static String url = "jdbc:mysql://localhost:3306/CollegeServay";
	final static String username = "root";
	final static String password = "Pixel@6444";
	

	public Connection getConnection() {
		Connection con=null;
		try {
			Class.forName(driverclass);
			con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			System.out.println("connection Failed");
		}
		return con;
	}
}
