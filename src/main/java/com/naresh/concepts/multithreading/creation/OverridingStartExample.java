package com.naresh.concepts.multithreading.creation;

/**
 * Demonstrates what happens when the start() method is overridden.
 * This is an advanced and interesting interview topic.
 */
class CustomStartThread extends Thread {

    /**
     * Overriding the start() method is generally not recommended, but if you do,
     * you MUST call super.start() to actually create a new thread.
     * Otherwise, you are just replacing the thread creation logic with a normal method call.
     */
    @Override
    public void start() {
        System.out.println("Custom logic inside overridden start() method.");
        // If you comment out the next line, no new thread will be created
        // and the run() method will never be executed.
        super.start();
    }

    @Override
    public void run() {
        System.out.println("run() method executed by new thread: " + Thread.currentThread().getName());
    }
}

public class OverridingStartExample {
    public static void main(String[] args) {
        CustomStartThread t = new CustomStartThread();
        t.start(); // This calls our overridden start() method.
        System.out.println("main() method executed by: " + Thread.currentThread().getName());
    }
}
