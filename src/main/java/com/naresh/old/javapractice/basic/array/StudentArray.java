package com.naresh.old.javapractice.basic.array;

public class StudentArray {
	String name;
	int age;
	public StudentArray(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public static void main(String[] args) {
		StudentArray[] students= new StudentArray[5];
		students[0] = new StudentArray("Naresh",24);
		students[1] = new StudentArray("Pratap",22);
		students[2] = new StudentArray("Pavan",23);
		students[3] = new StudentArray("Imran",24);
		students[4] = new StudentArray("Tirumal",25);
		for(StudentArray student : students){
			System.out.println("Student Name:"+student.name+" ,"+"Student Age :"+student.age);
		}
	}
}
