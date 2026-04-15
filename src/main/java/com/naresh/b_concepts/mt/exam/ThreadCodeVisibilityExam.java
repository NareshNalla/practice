package com.naresh.b_concepts.mt.exam;

public class ThreadCodeVisibilityExam extends Thread {
	int code = 9;

	public void run() {
		this.code = 7;
	}

	public static void main(String[] args) {
		ThreadCodeVisibilityExam thread = new ThreadCodeVisibilityExam();
		thread.start();
		for (int i = 0; i < 5; i++) {
			System.out.print(thread.code);
		}
	}
}

/*The thread can start running (executing run()) at any time before/within or after the loop. 
 * The possible output is 0-5 printings of "9" followed by 0-5 printings of "7". 
 * It is never possible to print "7"(s) followed by "9"(s)
 *
 */
