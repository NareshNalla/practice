package com.naresh.concepts.mt.exam;


public class Test5 extends Thread {
	static int count = 0;

	public static void main(String argv[]) {
		Test5 t = new Test5();
		t.increment(count);
		t.start();
		//Thread.sleep(1000); //Unresolved compilation problem:
		System.out.println(count);
	}

	public void increment(int count) {
		++count;
	}

	public void run() { count = count + 5; }
}

//Unresolved compilation problem: 