package com.naresh.multithreading.synchronization;

/**
 * Demonstrates the use of a synchronized method to achieve thread safety.
 */
class Counter {
    private int count = 0;

    // By adding the 'synchronized' keyword, we ensure that only one thread can execute this method
    // on a given instance of Counter at a time.
    // The lock is acquired on the object instance itself (the 'this' reference).
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizedMethodExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Create two threads that will increment the counter concurrently
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // If the increment() method were not synchronized, the final count would likely be
        // less than 20000 due to race conditions (lost updates).
        System.out.println("Final count: " + counter.getCount());
    }
}
