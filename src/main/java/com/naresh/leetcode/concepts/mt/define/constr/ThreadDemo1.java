package com.naresh.leetcode.concepts.mt.define.constr;

class MyThread1 implements Runnable{
	public void run(){
		
		System.out.println("Child Thread");
		
	}
}
public class ThreadDemo1 {
	public static void main(String[] args) {
		MyThread1 t=new MyThread1();
		Thread t1=new Thread(t);
		t1.start();
		System.out.println("IN ThreadDemo1:Main Thread");
		

	}

}
