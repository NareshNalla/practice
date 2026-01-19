package com.naresh.old.javapractice.mt.basics.single;

public class Test1 {
	public static void main(String[] args) {
		Thread t= Thread.currentThread();
		System.out.println(t.getName());
		System.out.println(t.getPriority());
		System.out.println(t.getThreadGroup().getName());
		System.out.println(t.isAlive());
		t.setName("parent most");
		t.setPriority(8);
		System.out.println(t.getName());
		System.out.println(t.getPriority());
		
	}

}
