package com.naresh.concepts.mt.defog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Shared1 {
	//static int count = 0;
	static AtomicInteger count = new AtomicInteger(0);
	
}

class MyThread1 extends Thread {
	Semaphore sem;
	String threadName;

	public MyThread1(Semaphore sem, String threadName) {
		super(threadName);
		this.sem = sem;
		this.threadName = threadName;
	}

	@Override
	public void run() {

		if (this.getName().equals("A")) {
			System.out.println("Starting " + threadName);
			try {
				System.out.println(threadName + " is waiting for a permit.");
				sem.acquireUninterruptibly(2);
				//sem.acquireUninterruptibly();
				//sem.acquire();
				System.out.println(threadName + " gets a permit.");
				for (int i = 0; i < 5; i++) {
					Shared.count.incrementAndGet();
					System.out.println(threadName + ": " + Shared.count);
					Thread.sleep(10);
				}
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
			System.out.println(threadName + " releases the permit.");
			//sem.release();
			sem.release(2);
		} 
	}
}

public class SemaphoreDemo1Executer {
	public static void main(String args[]) throws InterruptedException {
		Semaphore sem = new Semaphore(2);

		ExecutorService service = Executors.newFixedThreadPool(10);
		IntStream.of(100).forEach(i -> service.execute(new MyThread(sem, "A")));
		
		
		
		service.shutdown();
		service.awaitTermination(60, TimeUnit.SECONDS);
		System.out.println("count: " + Shared.count);
		
		/*
		 tryAcquire() 
		 tryAcquire(timeout)
		 availablePermits()
		 new Semaphore(count, fairness)
		 
		 */
	}
}