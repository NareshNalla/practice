package com.naresh.b_concepts.mt.exam;

public class SynchronizedNpeExam implements Runnable {
	Integer id;

	public static void main(String[] args) {
		new Thread(new SynchronizedNpeExam()).start();
		new Thread(new SynchronizedNpeExam()).start();
	}

	public void run() {
		printAndIncrementId(id);
	}

	synchronized void printAndIncrementId(Integer id) {
		System.out.print(id.intValue());
		System.out.print((++id).intValue());
	}
}
//NullPointerException
//"Thread-0" Exception in thread "Thread-1" java.lang.NullPointerException