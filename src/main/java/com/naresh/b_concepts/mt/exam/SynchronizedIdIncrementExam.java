package com.naresh.b_concepts.mt.exam;

public class SynchronizedIdIncrementExam implements Runnable {
	Integer id=0;

	public static void main(String[] args) {
		new Thread(new SynchronizedIdIncrementExam()).start();
		new Thread(new SynchronizedIdIncrementExam()).start();
	}

	public void run() {
		printAndIncrementId(id);
	}

	synchronized void printAndIncrementId(Integer id) {
		System.out.print(id.intValue());
		System.out.print((++id).intValue());
	}
}
//0011 or
//0101
/*The two threads are executing on two different instances of SynchronizedIdIncrementExam, which means that the two threads are working on two different instances of variable id.

The result "0123" is not possible, because each thread will start with value "0" for "id"

The result "1010" is not possible because "id" starts with value "0" then incremented to "1"

"0101" is a possible output, which happens the first thread to execute seizes the CPU till it finishes method printAndIncrementId()

Another scenario may happen when the the CPU switches between the two threads allowing each to execute one print statement at a time, this will result in the output "0011"*/