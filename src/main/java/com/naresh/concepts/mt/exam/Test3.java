package com.naresh.concepts.mt.exam;


public class Test3 extends Thread {
	public void run() {
		System.out.println("run");
	}

	public static void main(String[] args) {
		Thread thread = new Test3();
		thread.run();
		thread.start();
		thread.start();
	}
}
//The instance of Thread cannot invoke start() twice, else an 
//IllegalThreadStateException will be thrown