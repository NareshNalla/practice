package com.naresh.dsalgo.linkedlist.implementation;

public class DoublyLinkedListTest {
	public static void main(String[] args) {
		DoublyLinkedList<String> ls = new DoublyLinkedList<String>();
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
