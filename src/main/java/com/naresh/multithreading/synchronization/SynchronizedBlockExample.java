package com.naresh.multithreading.synchronization;

/**
 * Demonstrates the use of a synchronized block for more fine-grained locking.
 */
class FineGrainedCounter {
    private int count1 = 0;
    private int count2 = 0;

    // Using private lock objects is a common best practice to avoid external manipulation.
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void incrementCount1() {
        // This synchronized block only locks 'lock1'.
        // It does not prevent other threads from executing incrementCount2().
        synchronized (lock1) {
            count1++;
        }
    }

    public void incrementCount2() {
        // This synchronized block only locks 'lock2'.
        synchronized (lock2) {
            count2++;
        }
    }

    public void printCounts() {
        System.out.println("Count1: " + count1 + ", Count2: " + count2);
    }
}


public class SynchronizedBlockExample {
    public static void main(String[] args) throws InterruptedException {
        FineGrainedCounter counter = new FineGrainedCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementCount1();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementCount2();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        counter.printCounts();
    }
}
