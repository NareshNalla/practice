package com.naresh.old.javapractice.basic;

public class LinkedListTest {
	public static void main(String[] args) {
		
		LinkedListImpl<String> ll = new LinkedListImpl<String>();
		ll.add("Dhanraj");
		ll.add("Shiva");
		ll.add("Naresh");
		ll.add("Phani");
		ll.display();
		System.out.println("Before delete");
		ll.delete();
		System.out.println("After delete");
		ll.display();
		
	}

}
