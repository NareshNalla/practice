package com.naresh.dsalgo.queue.implementation;

public class QueueArrayTest {
	public static void main(String[] args) {
		QueueArray<Integer> qa = new QueueArray<Integer>(5);
		qa.queue(2);
		qa.queue(01);
		qa.queue(3);
		qa.queue(4);
		qa.queue(-1);
		System.out.println("Dequeu :"+qa.deQueue());
		System.out.println("Dequeu :"+qa.deQueue());
		
	}

}

