package com.naresh.old.javapractice.corejava.generics;

import java.util.ArrayList;
import java.util.List;

public class Test5 {


	public static void main(String[] args) {

		List list = new ArrayList();

		list.add("Hello");

		Foo f = new Foo();

		list.add(f); 

		f = list.get(1);

		System.out.print(list.get(0) + "-" + f);

	}

}

class Foo {

	public String toString() {

		return "Foo";

	}

}
/*Unresolved compilation problems: */
/*cannot convert from Object to Foo*/
