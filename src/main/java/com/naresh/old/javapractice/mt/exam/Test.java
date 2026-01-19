package com.naresh.old.javapractice.mt.exam;

public class Test implements Runnable {
	Integer id;

	public static void main(String[] args) {
		new Thread(new Test()).start();
		new Thread(new Test()).start();
	}

	public void run() {
		press(id);
	}

	synchronized void press(Integer id) {
		System.out.print(id.intValue());
		System.out.print((++id).intValue());
	}
}
//NullPointerException
//"Thread-0" Exception in thread "Thread-1" java.lang.NullPointerException