package com.naresh.corejava.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudentTest {

    public static void main(String[] args) {
	
	StreamStudent s1 = new StreamStudent(1,"naresh",25);
	StreamStudent s2 = new StreamStudent(1,"mounika",16);
	StreamStudent s3 = new StreamStudent(1,"ganga",10);
	
	List<StreamStudent> slist = new ArrayList<>( Arrays.asList(s1,s2,s3));
	
	//slist.add(s1); slist.add(s2); slist.add(s3);
	
	List l =slist.stream().filter(s -> s.age > 15).collect(Collectors.toList());
	System.out.println(l);
	
	Integer i = slist.stream().map(StreamStudent::getAge).reduce(0,(x,y)-> x+y);
	System.out.println(" sum of ages "+i);
    }
}

