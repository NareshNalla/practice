package com.naresh.old.javapractice.javaconcepts.corejava.generics;

import java.util.ArrayList;
import java.util.List;

interface chewable {}

class Gum implements chewable {}

public class Tester {

	public static void main(String[] args) {

		List<Gum> list1 = new ArrayList<Gum>();

		list1.add(new Gum());

		List list2 = list1;

		list2.add(new Integer(9));

		System.out.println(list2.size());

	}

}
/*o/p: 2*/