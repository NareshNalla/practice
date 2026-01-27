package com.naresh.concepts.multithreading.lifecycle;

class WorkerThread extends Thread {
    public WorkerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " started.");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
                System.out.println(getName() + " is working...");
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
            }
        }
        System.out.println(getName() + " finished.");
    }
}

public class JoinExample {
    public static void main(String[] args) {
        WorkerThread t1 = new WorkerThread("Worker-1");
        t1.start();

        System.out.println("Main thread is waiting for Worker-1 to finish.");

        try {
            // The main thread will pause here and wait until the t1 thread completes its execution.
            // This is essential for scenarios where one thread's work depends on the result of another.
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted while waiting.");
        }

        System.out.println("Worker-1 has finished. Main thread is resuming.");
    }
}
