  package com.naresh.concepts.mt;

public class PrintData implements Runnable {
	public void run() {
	    synchronized (this) {
		
	    	for (int i = 0; i <= 10; ++i) {
		    if(i % 2 == 0) {
			System.out.println("Printing record: " + i+" "+Thread.currentThread().getName());
		}else {
			System.out.println("Printing record: " + i+" "+Thread.currentThread().getName());
		}
	}

	}
	    notifyAll();
	    }


	public static void main(String[] args) throws InterruptedException {
		Thread t =(new Thread(new PrintData()));
		t.start();
		t.sleep(10);
		Thread t2 =(new Thread(new PrintData()));
		t2.start();
		t2.sleep(10);
	}
}
