package com.mindtree.collageServay.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.collageServay.Entity.College;
import com.mindtree.collageServay.Entity.Student;
import com.mindtree.collageServay.Exception.DaoEcxeption;
import com.mindtree.collageServay.Exception.ServiceException;
import com.mindtree.collageServay.dao.daoLayer.DaoImplementation;

public class Service {
	Scanner sc=new Scanner(System.in);
	DaoImplementation dao=new DaoImplementation();
	public List<College>addCollege(List<College>college){
		
		System.out.println("Enter collegeName");
		String collegeName=sc.nextLine();
		for(College c:college) {
			while(c.getCollageName().equalsIgnoreCase(collegeName)) {
				System.out.println("college already exists please enter another collegeName");
				collegeName=sc.nextLine();
			}
		}
		System.out.println("Enter College strength");
		int strength=sc.nextInt();
		sc.nextLine();
		college.add(new College(collegeName,strength));
		dao.addCollegeSql(collegeName,strength);
		return college;
	}
	
	
	
	
	
	public List<Student>addStudent(List<Student>student,List<College>college){
		System.out.println("Enter college Name");
		String collegeName=sc.nextLine();
		for(College c:college) {
			if(c.getCollageName().equalsIgnoreCase(collegeName)) {
				System.out.println("enter Student Name");
				String studentName=sc.nextLine();
				System.out.println("enter StudentAge");
				int age=sc.nextInt();
				sc.nextLine();
				System.out.println("enter subject(Arts/Science/Commerce)");
				String subject =sc.nextLine();
				student.add(new Student(collegeName,studentName,age,subject));
				dao.addStudentSql(collegeName, studentName, age, subject);
				break;
			}
		}
		return student;
	}
	
	
	
	
	
	
	public void fetchAllStudents() throws ServiceException {
		List<String> allCollegeData=new ArrayList<String>();
			try {
				ResultSet rs=dao.allCollegeDetailsSql();
				while (rs.next()) {
					String temp = "CollegeName: '" + rs.getString("collegeName") + "' Strength: '" + rs.getInt("strength")
							+ "' studentName: '" + rs.getString("studentName") + "' Age:'" + rs.getInt("age")
							+ "' subject: '" + rs.getString("subject") + "'";
					allCollegeData.add(temp);
				}
			} catch (DaoEcxeption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(allCollegeData.isEmpty()) {
				throw new ServiceException("error while fetching college data");
			}else {
				for(String s:allCollegeData) {
					System.out.println(s);
				}
			}
		
	}
	
	
	
	
	
	
	public void specificData()throws ServiceException{
		List<String> specificdata=new ArrayList<String>();
		try {
			ResultSet rs = dao.specificDataSql();
			while (rs.next()) {
				String temp = "collegeName: '" + rs.getString("collegeName") + "' strength: '" + rs.getInt("strength")
						+ "' StudentName: '" + rs.getString("StudentName") + "' Age: '" + rs.getInt("age")
						+ "' subject: '" + rs.getString("subject") + "'";
				specificdata.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoEcxeption e) {
			
		}
		
		if(specificdata.isEmpty()) {
			throw new ServiceException("data not found with given inputs");
		}else {
			for(String s:specificdata) {
				System.out.println(s);
			}
		}
	}
	
	
	
	
	public List<College>previousData(List<College>college){
		
			ResultSet rs=dao.fetchingData();
			
			try {
				while (rs.next()) {
					College c = new College();
					c.setCollageName(rs.getString("collegeName"));
					c.setStrength(rs.getInt("strength"));
					college.add(c);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return college;
		
	}
}
