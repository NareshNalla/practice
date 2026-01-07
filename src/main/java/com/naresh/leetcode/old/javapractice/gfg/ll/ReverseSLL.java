package com.naresh.leetcode.old.javapractice.gfg.ll;

public class ReverseSLL {
	static Node2 head;

	public static void main(String[] args) {
		insert(1);
		insert(3);
		insert(6);
		insert(10);
		print();
		// reverse();
		// print();
		 recursiveReverse(head);
		 print();
		//Node2 res =reverseUtil(head, null);
		//	print1(res);
	//	Node2 res =	reverseRecursive(head, null);
	//	print1(res);
	}

	private static void recursiveReverse(Node2 head) {
		Node2 first;
		Node2 rest;

		if (head == null)
			return ;

		first = head;
		rest = first.next;

		if (rest == null)
			return;

		recursiveReverse(rest);

		first.next.next = first;
		first.next = null;
		head = rest;


	}

	/*
	 * Time Complexity: O(n) Space Complexity: O(1) Iterative Method
	 */
	private static void reverse() {

		Node2 current = head;
		Node2 next = null;
		Node2 prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	/* Tail Recursive Method */
	public static Node2 reverseUtil(Node2 curr, Node2 prev) {
		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return null;
		}

		Node2 next1 = curr.next;

		curr.next = prev;

		reverseUtil(next1, curr);
		return head;
	}

	public static Node2 reverseRecursive(Node2 curr, Node2 prev) {
		if (curr == null)
			return prev;
		Node2 next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
		return reverseRecursive(next, prev);
	}

	private static void print1(Node2 n) {
		while (n != null) {
			System.out.print(n.value + " - >");
			n = n.next;
		}
		System.out.println("null");

	}

	private static void print() {
		Node2 n = head;
		while (n != null) {
			System.out.print(n.value + " - >");
			n = n.next;
		}
		System.out.println("null");

	}

	private static void insert(int new_data) {

		Node2 new_node = new Node2(new_data);
		if (head == null) {
			head = new_node;
			return;
		}
		new_node.next = null;
		Node2 last = head;
		while (last.next != null)
			last = last.next;
		last.next = new_node;
		return;

	}
}

class Node2 {
	Node2 next;
	int value;

	Node2(int value) {
		this.next = null;
		this.value = value;
	}
}
