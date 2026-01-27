package com.naresh.dsa.basic.queue;

public class QueueLinkedListTest {
	public static void main(String[] args) {
		QueueLinkedListImpl<String> ql = new QueueLinkedListImpl<String>();
		ql.queue("Love");
		ql.queue("Hate");
		ql.queue("Friends");
		System.out.println("Dequeu :"+ql.deQueue());
		System.out.println("Dequeu :"+ql.deQueue());
		System.out.println("Dequeu :"+ql.deQueue());
	}

}
