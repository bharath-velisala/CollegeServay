package com.mindtree.collageServay.dao.daoLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.mindtree.collageServay.DBUtil.DButility;
import com.mindtree.collageServay.Exception.DaoEcxeption;

public class DaoImplementation {
	DButility dbconnect = new DButility();
	Scanner sc = new Scanner(System.in);
	static ResultSet rs;
	static PreparedStatement pst;
	static Statement st;

	public void addCollegeSql(String collegeName, int strength) {
		String Query = "insert into College VALUES('" + collegeName + "','" + strength + "')";
		try {
			pst = dbconnect.getConnection().prepareStatement(Query);
			pst.execute();
		} catch (SQLException e) {
			System.out.println("error in sql command");
		}
	}

	public void addStudentSql(String collegeName, String studentName, int age, String subject) {
		String Query = "insert into students values('" + collegeName + "','" + studentName + "','" + age + "','"
				+ subject + "')";
		try {
			pst = dbconnect.getConnection().prepareStatement(Query);
			pst.execute();
		} catch (SQLException e) {

			System.out.println("error in sql command");
		}
	}

	public ResultSet allCollegeDetailsSql() throws DaoEcxeption {

		String Query = "select *from college inner join students on college.collegeName=students.collegeName order by strength,college.collegeName";

		try {
			st = dbconnect.getConnection().createStatement();
			rs = st.executeQuery(Query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public ResultSet specificDataSql() throws DaoEcxeption {
		System.out.println("enter collegename");
		String collegeName = sc.nextLine();
		System.out.println("enter subject");
		String subject = sc.nextLine();
		ResultSet rs = null;
		String Query = "select *from college inner join students on college.collegeName=students.collegeName where college.collegeName='"
				+ collegeName + "' and subject='" + subject + "' order by age desc,students.studentName desc";
		try {
			Statement st = dbconnect.getConnection().createStatement();
			rs = st.executeQuery(Query);

		} catch (SQLException e) {
			throw new DaoEcxeption();
		}
		return rs;
	}

	public ResultSet fetchingData() {
		

		try {
			String Query = "select *from College";
			Statement st = dbconnect.getConnection().createStatement();
			rs = st.executeQuery(Query);
			
		} catch (SQLException e) {
			System.out.println("error occured while fetching previous data");
		}
		return rs;

	}
}
