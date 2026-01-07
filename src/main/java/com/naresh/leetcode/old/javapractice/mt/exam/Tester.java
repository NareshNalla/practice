
package com.naresh.leetcode.old.javapractice.mt.exam;

public class Tester {

	public void validate() {
		int i = 0;
		while (++i < 3) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(i);
		}
	}
	public static void main(String[] args) {
		new Tester().validate();
	}

}
// java.lang.IllegalMonitorStateException
//If the thread calling wait() does not own the lock on the object, 
//a IllegalMonitorStateException will be thrown.
// its main thread 