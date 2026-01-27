package com.naresh.concepts.multithreading.creation;

/**
 * Demonstrates creating a thread by implementing the Runnable interface.
 * This is the PREFERRED way to create threads in Java.
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class RunnableCreationExample {
    public static void main(String[] args) {
        // Why is implementing Runnable preferred over extending Thread?
        // 1. Java does not support multiple inheritance. If you extend Thread, you cannot extend any other class.
        //    By implementing Runnable, your class is free to extend another class.
        // 2. It promotes a better separation of concerns. Your class is just a task to be run (a Runnable),
        //    it is not a Thread itself. The Thread class is responsible for the execution logic.

        MyRunnable myRunnable = new MyRunnable();

        // Create a Thread object and pass the Runnable instance to its constructor.
        Thread t1 = new Thread(myRunnable, "Thread-A");
        Thread t2 = new Thread(myRunnable, "Thread-B");

        // Start the threads. The same Runnable instance's run() method will be executed by two different threads.
        t1.start();
        t2.start();

        System.out.println("Main thread finished.");
    }
}
