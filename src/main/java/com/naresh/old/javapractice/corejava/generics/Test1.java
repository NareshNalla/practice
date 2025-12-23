package com.naresh.old.javapractice.corejava.generics;

import java.util.ArrayList;
import java.util.List;

interface chewable {}

class Gum /* implements chewable*/ {}

class Meat /*implements chewable*/ {}

public class Test1 {

	public static void main(String[] args) {

		List list1 = new ArrayList<chewable>();// line 1

		list1.add(new Gum());// line 2

		list1.add(new Meat());// line 3

		list1.add(new Integer(9));// line 4

		System.out.println(list1.size());// line 5

	}

}