package com.naresh.concepts.multithreading.properties;

class MyTaskThread extends Thread {
    @Override
    public void run() {
        System.out.println("Executing thread: " + Thread.currentThread().getName());
        System.out.println("Priority of this thread: " + Thread.currentThread().getPriority());
    }
}

public class ThreadPropertiesExample {
    public static void main(String[] args) {
        // Getting properties of the main thread
        Thread mainThread = Thread.currentThread();
        System.out.println("Main thread name: " + mainThread.getName());
        System.out.println("Main thread priority: " + mainThread.getPriority()); // Default is 5

        System.out.println("---------------------------------");

        // Creating and setting properties for a new thread
        MyTaskThread t1 = new MyTaskThread();

        // Set the thread name for better debugging and logging
        t1.setName("My-Custom-Thread-1");

        // Set the thread priority.
        // The valid range is from Thread.MIN_PRIORITY (1) to Thread.MAX_PRIORITY (10).
        // Thread.NORM_PRIORITY is 5.
        // NOTE: Thread priority is a hint to the scheduler and its behavior can vary across different OS.
        t1.setPriority(Thread.MAX_PRIORITY);

        t1.start();
    }
}
