package com.naresh.leetcode.old.javapractice.java8.mt;

public class Test {
	public static void main(String[] args) {
		System.out.println("begin");
		(new ReadInventoryThread()).start();
		(new Thread(new PrintData())).start();
		(new ReadInventoryThread()).start();
		System.out.println("end");
		}

}
