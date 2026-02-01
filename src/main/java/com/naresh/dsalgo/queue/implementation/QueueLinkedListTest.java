package com.naresh.dsalgo.queue.implementation;

public class QueueLinkedListTest {
	public static void main(String[] args) {
		QueueLinkedList<String> ql = new QueueLinkedList<String>();
		ql.queue("Love");
		ql.queue("Hate");
		ql.queue("Friends");
		System.out.println("Dequeu :"+ql.deQueue());
		System.out.println("Dequeu :"+ql.deQueue());
		System.out.println("Dequeu :"+ql.deQueue());
	}

}
