package com.naresh.leetcode.old.javapractice.java8.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentTest {

    public static void main(String[] args) {
	
	Student s1 = new Student(1,"naresh",25);
	Student s2 = new Student(1,"mounika",16);
	Student s3 = new Student(1,"ganga",10);
	
	List<Student> slist = new ArrayList<>( Arrays.asList(s1,s2,s3));
	
	//slist.add(s1); slist.add(s2); slist.add(s3);
	
	List l =slist.stream().filter(s -> s.age > 15).collect(Collectors.toList());
	System.out.println(l);
	
	Integer i = slist.stream().map(Student::getAge).reduce(0,(x,y)-> x+y);
	System.out.println(" sum of ages "+i);
    }
}

