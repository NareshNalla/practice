package com.naresh.old.javapractice.javaconcepts.corejava.generics;

import java.util.*;

public class Test9 {

	public static void main(String[] args) {

		

		// insert code here
    Map<List,Integer> map = new HashMap<>();
		map.put(new ArrayList<Integer>(), 1);

		map.put(new ArrayList<Integer>(), 12);

		map.put(new LinkedList<Integer>(), Integer.valueOf(1));


	}

}