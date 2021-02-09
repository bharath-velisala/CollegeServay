package com.mindtree.collageServay.dao.daoLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.collageServay.Entity.College;
import com.mindtree.collageServay.Exception.DaoEcxeption;

public class DaoImplementation {
	Scanner sc = new Scanner(System.in);
	final static String driverclass = "com.mysql.cj.jdbc.Driver";
	final static String url = "jdbc:mysql://localhost:3306/CollegeServay";
	final static String username = "root";
	final static String password = "Pixel@6444";
	static Connection con;
	static PreparedStatement st;
	static {
		try {
			Class.forName(driverclass);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			System.out.println("connection Failed");
		}

	}

	
	
	
	public void addCollegeSql(String collegeName, int strength){
		String Query = "insert into College VALUES('" + collegeName + "','" + strength + "')";
		try {
			st = con.prepareStatement(Query);
			st.execute();
		} catch (SQLException e) {
			System.out.println("error in sql command");
		}
	}

	
	
	
	
	public void addStudentSql(String collegeName, String studentName, int age, String subject) {
		String Query = "insert into students values('" + collegeName + "','" + studentName + "','" + age + "','"
				+ subject + "')";
		try {
			st = con.prepareStatement(Query);
			st.execute();
		} catch (SQLException e) {
			
			System.out.println("error in sql command");
		}
	}

	
	
	
	
	public List<String> allCollegeDetailsSql()throws DaoEcxeption{
		List<String> studentDetails = new ArrayList<String>();
		String Query = "select *from college inner join students on college.collegeName=students.collegeName order by strength,college.collegeName";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Query);
			while (rs.next()) {
				String temp = "CollegeName: '" + rs.getString("collegeName") + "' Strength: '" + rs.getInt("strength")
						+ "' studentName: '" + rs.getString("studentName") + "' Age:'" + rs.getInt("age")
						+ "' subject: '" + rs.getString("subject") + "'";
				studentDetails.add(temp);
			}
		} catch (SQLException e) {
		}
		
		if(studentDetails.isEmpty()) {
			throw new DaoEcxeption();
		}
		return studentDetails;
	}

	
	
	
	public List<String> specificDataSql() throws DaoEcxeption {
		List<String> specificdata = new ArrayList<String>();
		System.out.println("enter collegename");
		String collegeName = sc.nextLine();
		System.out.println("enter age");
		String subject = sc.nextLine();

		String Query = "select *from college inner join students on college.collegeName=students.collegeName where college.collegeName='"
				+ collegeName + "' and subject='" + subject + "' order by age desc,students.studentName desc";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Query);
			while (rs.next()) {
				String temp = "collegeName: '" + rs.getString("collegeName") + "' strength: '" + rs.getInt("strength")
						+ "' StudentName: '" + rs.getString("StudentName") + "' Age: '" + rs.getInt("age")
						+ "' subject: '" + rs.getString("subject") + "'";
				specificdata.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(specificdata.isEmpty()) {
			throw new DaoEcxeption();
		}
		return specificdata;
	}

	
	
	
	
	
	public List<College> fetchingData() {
		List<College> college = new ArrayList<College>();

		try {
			String Query = "select *from College";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Query);
			while (rs.next()) {
				College c = new College();
				c.setCollageName(rs.getString("collegeName"));
				c.setStrength(rs.getInt("strength"));
				college.add(c);
			}
		} catch (SQLException e) {
			System.out.println("error occured while fetching previous data");
		}
		return college;

	}
}
