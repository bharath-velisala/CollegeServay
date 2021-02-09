package com.mindtree.collageServay.services;

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
		
		List<String> studentDetails;
		try {
			studentDetails = dao.allCollegeDetailsSql();
			for(String s:studentDetails) {
				System.out.println(s);
			}
		} catch (DaoEcxeption e) {
			throw new ServiceException("error while fetching all college details details");
		}
		
		
	}
	
	
	
	
	
	
	public void specificData()throws ServiceException{
		List<String> specificdata;
		try {
			specificdata = dao.specificDataSql();
			for(String s:specificdata) {
				System.out.println(s);
			}
		} catch (DaoEcxeption e) {
			throw new ServiceException("data not found with given inputs");
		}
	}
	
	
	
	
	public List<College>previousData(List<College>college){
			college=dao.fetchingData();
			return college;
		
	}
}
