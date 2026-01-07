package com.naresh.multithreading.lifecycle;

class YieldingThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - in control");

            // Thread.yield() is a hint to the thread scheduler.
            // It suggests that the current thread is willing to yield its current use of a processor.
            // The scheduler is free to ignore this hint.
            // There is NO GUARANTEE that the scheduler will switch to another thread.
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " - finished.");
    }
}

public class YieldExample {
    public static void main(String[] args) {
        YieldingThread t1 = new YieldingThread();
        t1.setName("Thread 1");

        YieldingThread t2 = new YieldingThread();
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
