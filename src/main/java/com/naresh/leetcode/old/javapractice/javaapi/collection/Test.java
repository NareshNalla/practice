package com.naresh.leetcode.old.javapractice.javaapi.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("1", "Naresh");
		hm.put("2", "Nalla");

		System.out.println(hm.get("1"));
		for (String h : hm.keySet()) {
			System.out.print(" " + h);

		}
		for (Entry e : hm.entrySet()) {

			System.out.print("Key:" + e.getKey() + "Value:" + e.getValue());
		}
	}

}
