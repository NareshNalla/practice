package com.naresh.multithreading.creation;

class SimpleThread extends Thread {
    public void run() {
        System.out.println("Thread is running.");
    }
}

public class IllegalThreadStateExample {
    public static void main(String[] args) {
        SimpleThread t = new SimpleThread();

        // 1. First call to start() is valid.
        // This moves the thread from the NEW state to the RUNNABLE state.
        t.start();

        System.out.println("First start() call completed.");

        try {
            // 2. Second call to start() on the same thread instance is illegal.
            // A thread that has been started cannot be started again.
            // This will throw an IllegalThreadStateException.
            System.out.println("Attempting to call start() again...");
            t.start();
        } catch (IllegalThreadStateException e) {
            System.out.println("Caught expected exception: " + e);
            System.out.println("A thread cannot be started more than once.");
        }
    }
}
