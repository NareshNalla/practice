package com.naresh.old.javapractice.javaapi.collection;

import java.util.stream.Stream;


public class EmployeeTestMain {


    public static void main(String args[]) {

	EmployeeModel e1 = new EmployeeModel("Naresh", 31);
	EmployeeModel e2 = new EmployeeModel("Kiran", 20);
	EmployeeModel e3 = new EmployeeModel("Pavan", 11);

	EmployeeModel e4 = new EmployeeModel("Aamesh", 11);

	Stream.of(e1,e2,e3,e4).sorted().forEach(System.out::println);

	System.out.println(e1.compareTo(e2));

	System.out.println(e1.compareTo("Naresh"));

    }

}