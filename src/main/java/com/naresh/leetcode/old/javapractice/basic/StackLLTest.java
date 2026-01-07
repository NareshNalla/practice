package com.naresh.leetcode.old.javapractice.basic;

public class StackLLTest {
	public static void main(String[] args) {
		
		StackLinkedListImpl<String> sl = new StackLinkedListImpl<String>();
		sl.pop();
		sl.push("Ramu");
		sl.push("Faheem");
		sl.push("Naresh");
		
		System.out.println(sl.pop());
	}
}
