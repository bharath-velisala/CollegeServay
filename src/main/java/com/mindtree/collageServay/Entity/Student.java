package com.mindtree.collageServay.Entity;

public class Student {
	private String CollegeName;
	private String studentName;
	private int age;
	private String subject;
	public Student() {
		super();
	}
	public Student(String collegeName, String studentName, int age, String subject) {
		super();
		CollegeName = collegeName;
		this.studentName = studentName;
		this.age = age;
		this.subject = subject;
	}
	public String getCollegeName() {
		return CollegeName;
	}
	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}
