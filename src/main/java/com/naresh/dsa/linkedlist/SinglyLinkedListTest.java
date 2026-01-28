package com.naresh.dsa.linkedlist;

public class SinglyLinkedListTest {
	public static void main(String[] args) {
		
		SinglyLinkedList<String> ll = new SinglyLinkedList<String>();
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
