package com.naresh.old.javapractice.javaconcepts.corejava.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test4{

	public static void main(String[] args) {

		List<Foo> myFooList = new ArrayList<Foo>();

		myFooList.add(new Foo("C"));

		myFooList.add(new Foo("A"));

		myFooList.add(new Foo("D"));

		Collections.sort(myFooList); 

		System.out.print(myFooList.get(0).code);

	}

}

class Foo implements Comparable<Foo> {

	String code;

	Foo(String c) {

		code = c;

	}

	public int compareTo(Foo f) { //public is mandatory

		return this.code.compareTo(f.code);

	}

}

/*ava.lang.IllegalAccessError: com.test.Foo.compareTo(Ljava/lang/Object;)I*/