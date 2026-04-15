package com.naresh.b_concepts.mt.exam;


public class IllegalThreadStateExam extends Thread {
	public void run() {
		System.out.println("run");
	}

	public static void main(String[] args) {
		Thread thread = new IllegalThreadStateExam();
		thread.run();
		thread.start();
		thread.start();
	}
}
//The instance of Thread cannot invoke start() twice, else an 
//IllegalThreadStateException will be thrown