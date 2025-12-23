package com.naresh.old.javapractice.corejava.generics;

import java.util.ArrayList;
import java.util.List;

interface Chewable1 {}

class Meat1 implements Chewable {}

public class Test3 {

	public static List<? extends Chewable1> printSize(List<? extends Chewable1> list) { // Line 10

		System.out.println(list.size());

		return list;

	}

	public static void main(String[] args) {

		List<? extends Chewable1> list1 = new ArrayList<Meat1>(); // Line 16

		List<Chewable1> list2 = new ArrayList<Chewable1>(); // Line 17

		List<Meat1> list3 = new ArrayList<Meat1>(); // Line 18

		list1 = printSize(list1); // Line 20

		list2 = printSize(list2); // Line 21

		list3 = printSize(list3); // Line 22

	}

}

/*cannot convert from ArrayList<Meat> to List<? extends Chewable>*/
/*printSize(List<? extends Chewable>) f*/