package com.naresh.dsa.basic.queue;

public class QueueDynamicArrayTest {
	
	public static void main(String[] args) {
		QueueDynamicArrayImpl<Integer> qa = new QueueDynamicArrayImpl<Integer>(2);
		qa.queue(11);
		qa.queue(12);
		System.out.println("Size :"+qa.getSize());
		qa.queue(3);
		System.out.println("Size :"+qa.getSize());
		System.out.println("Dequeu :"+qa.deQueue());
		System.out.println("Size :"+qa.getSize());
	}
}
