package com.naresh.concepts.mt.setget.prio;



class MyThread extends Thread{
	public void run(){
		System.out.println("Child");
		System.out.println(Thread.currentThread().getPriority());
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		MyThread t=new MyThread();
		
		t.start();
		//t.setPriority(2);
		Thread.currentThread().setPriority(10);
		System.out.println(Thread.currentThread().getPriority());
		
	}

}
