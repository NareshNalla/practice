package com.naresh.old.javapractice.corejava.generics;

import java.util.ArrayList;
import java.util.List;

interface Chewable {}

class Meat implements Chewable {}

public class Test2 {

	public static void main(String[] args) {

		

		List<? extends Chewable> list1 = new ArrayList<Meat>(); // Line 11

		 //cannot convert from ArrayList<Meat> to List<? extends Chewable> //

		List<Chewable> list2           = new ArrayList<Chewable>(); // Line 13

		

		Meat meat = new Meat();

		

		list1.add(meat); // Line 17

		

		list2.add(meat); // Line 19

	}

}
}
