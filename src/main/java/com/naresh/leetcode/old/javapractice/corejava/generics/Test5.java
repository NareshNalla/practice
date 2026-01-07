package com.naresh.leetcode.old.javapractice.corejava.generics;

import java.util.ArrayList;
import java.util.List;

public class Test5 {


	public static void main(String[] args) {

		List list = new ArrayList();

		list.add("Hello");

		Foo1 f = new Foo1();

		list.add(f); 

		f = (Foo1) list.get(1);

		System.out.print(list.get(0) + "-" + f);

	}

}

class Foo1 {

	public String toString() {

		return "Foo";

	}

}
/*Unresolved compilation problems: */
/*cannot convert from Object to Foo*/
