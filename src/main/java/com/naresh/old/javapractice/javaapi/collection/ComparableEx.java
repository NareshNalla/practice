package com.naresh.old.javapractice.javaapi.collection;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableEx {
	
	public static void main(String[] args) {
		ArrayList<Student> s= new ArrayList<Student>();
		
		s.add(new Student(1, "Naresh"));
		s.add(new Student(12, "Nalla"));
		s.add(new Student(7, "Varan"));
		Collections.sort(s);
		for(Student i:s){
			System.out.println(" "+i.age);
		}
	}
}
