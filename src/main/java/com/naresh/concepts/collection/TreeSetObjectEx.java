package com.naresh.concepts.collection;

import java.util.TreeSet;

public class TreeSetObjectEx {
    public static void main(String[] args) {
	TreeSet<Integer> numbersTS = new TreeSet<>();

	for (int i = 4; i < 10; i++) {
	    numbersTS.add(i);
	}

	System.out.println(numbersTS);
	
	TreeSet<Student> objectTS = new TreeSet<>();
	objectTS.add( new Student(3, "Naresh1",8));
	objectTS.add( new Student(2, "mounika",9));
	objectTS.add( new Student(8, "ganga",4));
	objectTS.add( new Student(1, "hadvi",7));
	
	objectTS.stream().forEach(x-> {
	   System.out.println(x.age +" "+x.name);  
	});
    }

}

