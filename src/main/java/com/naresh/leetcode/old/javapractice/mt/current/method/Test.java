package com.naresh.leetcode.old.javapractice.mt.current.method;

public class Test {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		System.out.println(".........Setting Name.......");
		Thread.currentThread().setName("Naresh");
		System.out.println(Thread.currentThread().getName());
		System.out.println("..............Setting Prio................");
		System.out.println(Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(8);
		System.out.println(Thread.currentThread().getPriority());
		System.out.println("...................................");
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().isAlive());
		System.out.println(Thread.currentThread().isDaemon());
		System.out.println("Max Priory :"+Thread.MAX_PRIORITY);
		System.out.println("Min Pri :"+Thread.MIN_PRIORITY);
		System.out.println("Defaul :"+Thread.NORM_PRIORITY);
		
		
	}

}
