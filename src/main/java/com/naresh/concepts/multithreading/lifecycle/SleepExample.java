package com.naresh.concepts.multithreading.lifecycle;

public class SleepExample {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        // Thread 1 will acquire the lock and then sleep
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 1 acquired the lock.");
                try {
                    System.out.println("Thread 1 is sleeping for 2 seconds...");
                    // Thread.sleep() causes the current thread to pause for a specified time.
                    // CRITICAL: It does NOT release any locks it holds.
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 woke up and is releasing the lock.");
            }
        }, "Thread-1");

        // Thread 2 will try to acquire the same lock
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 is waiting to acquire the lock.");
            synchronized (lock) {
                // This block will only be executed AFTER thread1 wakes up and releases the lock.
                System.out.println("Thread 2 acquired the lock.");
            }
        }, "Thread-2");

        thread1.start();
        
        // Small delay to ensure thread1 starts and acquires the lock first
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        thread2.start();
    }
}
