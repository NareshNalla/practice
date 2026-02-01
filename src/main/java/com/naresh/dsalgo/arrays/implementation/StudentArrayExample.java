package com.naresh.dsalgo.arrays.implementation;

public class StudentArrayExample {
	String name;
	int age;
	public StudentArrayExample(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public static void main(String[] args) {
		StudentArrayExample[] students= new StudentArrayExample[5];
		students[0] = new StudentArrayExample("Naresh",24);
		students[1] = new StudentArrayExample("Pratap",22);
		students[2] = new StudentArrayExample("Pavan",23);
		students[3] = new StudentArrayExample("Imran",24);
		students[4] = new StudentArrayExample("Tirumal",25);
		for(StudentArrayExample student : students){
			System.out.println("Student Name:"+student.name+" ,"+"Student Age :"+student.age);
		}
	}
}
