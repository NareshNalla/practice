package com.naresh.leetcode.concepts.mt.exam;



public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		Runnable t1 = new Runnable() {
			public void run() {
				try {
					System.out.print("t1 before");
					Thread.sleep(100);
					System.out.print("t1 after");
				} catch (InterruptedException e) {
				}
			}
		};
		final Thread t2 = new Thread() {
			public void run() {
				System.out.print("t2 before");
				/*try {
					System.out.print("t2before");
					wait();
					System.out.print("t2after");
				} catch (InterruptedException e) {
				}*/
			}
		};
		t2.start();
		new Thread(t1).start();
	}
}
// t2beforet1beforet1after