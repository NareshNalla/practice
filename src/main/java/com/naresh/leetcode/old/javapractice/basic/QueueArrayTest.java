package com.naresh.leetcode.old.javapractice.basic;

public class QueueArrayTest {
	public static void main(String[] args) {
		QueueArrayImpl<Integer> qa = new QueueArrayImpl<Integer>(5);
		qa.queue(2);
		qa.queue(01);
		qa.queue(3);
		qa.queue(4);
		qa.queue(-1);
		System.out.println("Dequeu :"+qa.deQueue());
		System.out.println("Dequeu :"+qa.deQueue());
		
	}

}

