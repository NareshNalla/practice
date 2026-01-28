package com.naresh.dsa.stack;

public class StackLinkedListTest {
	public static void main(String[] args) {
		
		StackLinkedList<String> sl = new StackLinkedList<String>();
		sl.pop();
		sl.push("Ramu");
		sl.push("Faheem");
		sl.push("Naresh");
		
		System.out.println(sl.pop());
	}
}
