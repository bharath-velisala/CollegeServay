package com.mindtree.collageServay.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.protobuf.Message;
import com.mindtree.collageServay.Entity.College;
import com.mindtree.collageServay.Entity.Student;
import com.mindtree.collageServay.Exception.ServiceException;
import com.mindtree.collageServay.services.Service;

public class App extends Service{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		App app=new App();
		boolean flag=true;
		List<College>college=new ArrayList<College>();
		List<Student>student=new ArrayList<Student>();
		college=app.previousData(college);
		///////////////gdfgdgdfg
		
		do {
			System.out.println("press 1 to add college");
			System.out.println("press 2 to add students");
			System.out.println("press 3 fetch all the students");
			System.out.println("press 4 fetch data based on college and age");
			System.out.println("press 5 to exit");
			int a=sc.nextInt();
			sc.nextLine();
			switch(a) {
			case 1:
				app.addCollege(college);
				break;
			case 2:
				app.addStudent(student, college);
				break;
			case 3:
				try {
					app.fetchAllStudents();
				} catch (ServiceException e1) {
					System.out.println(e1);
				}
				break;
			case 4:
				try {
					app.specificData();
				} catch (ServiceException e) {
					System.out.println(e);
				}
				break;
			case 5:
				flag=false;
				break;
			}
		}while(flag!=false);
	}
}
