package com.naresh.concepts.multithreading.creation;

/**
 * Demonstrates the crucial difference between calling thread.start() and thread.run().
 * This is a very common interview question.
 */
class MyThread extends Thread {
    public void run() {
        System.out.println("run() method executed by: " + Thread.currentThread().getName());
    }
}

public class StartVsRunExample {
    public static void main(String[] args) {
        MyThread t = new MyThread();

        System.out.println("Demonstrating t.run() - executes on the main thread.");
        t.run(); // This is just a normal method call on the 't' object.
                 // The code inside run() will be executed by the main thread.

        System.out.println("---------------------------------");

        System.out.println("Demonstrating t.start() - creates a new thread.");
        t.start(); // This creates a new thread of execution.
                   // The JVM will then call the run() method on that new thread.

        System.out.println("main() method executed by: " + Thread.currentThread().getName());
    }
}
