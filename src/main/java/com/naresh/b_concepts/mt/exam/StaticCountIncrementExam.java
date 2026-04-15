package com.naresh.b_concepts.mt.exam;


public class StaticCountIncrementExam extends Thread {
	static int count = 0;

	public static void main(String argv[]) {
		StaticCountIncrementExam t = new StaticCountIncrementExam();
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