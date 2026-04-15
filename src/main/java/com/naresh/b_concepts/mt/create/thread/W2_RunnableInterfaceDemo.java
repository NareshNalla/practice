package com.naresh.b_concepts.mt.create.thread;

class MyThread1 implements Runnable{
	public void run(){
		System.out.println("Child Thread");
	}
}
public class W2_RunnableInterfaceDemo {
	public static void main(String[] args) {
		MyThread1 t=new MyThread1();
		Thread t1=new Thread(t);
		t1.start();
		System.out.println("IN ThreadDemo1:Main Thread");
		

	}

}
