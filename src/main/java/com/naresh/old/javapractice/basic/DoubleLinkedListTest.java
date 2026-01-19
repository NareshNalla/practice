package com.naresh.old.javapractice.basic;

public class DoubleLinkedListTest {
	public static void main(String[] args) {
		DoubleLinkedListI<String> ls = new DoubleLinkedListI<String>();
		ls.add("Suresh");
		ls.add("Prem");
		ls.add("Naresh");
		ls.add("Akshay");
		ls.diplay();
		System.out.println("Before delete");
		ls.delete();
		System.out.println("After delete");
		ls.diplay();
	}

}
