package com.naresh.concepts.multithreading.properties;

public class DaemonThreadExample {
    public static void main(String[] args) {
        // Create a new thread
        Thread workerThread = new Thread(() -> {
            try {
                System.out.println("Worker thread started.");
                // This thread will run for 10 seconds
                Thread.sleep(10000);
                System.out.println("Worker thread finished."); // This line will not be reached if it's a daemon thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // By default, a thread is a non-daemon (user) thread.
        // The JVM will wait for all non-daemon threads to complete before exiting.

        // If you uncomment the next line, the workerThread will become a daemon thread.
        // A daemon thread is a low-priority thread that runs in the background.
        // The JVM will NOT wait for daemon threads to finish. It will exit as soon as
        // all non-daemon threads (in this case, just the main thread) are done.
        // workerThread.setDaemon(true);

        workerThread.start();

        System.out.println("Main thread has finished its work.");
        System.out.println("Is worker thread a daemon? " + workerThread.isDaemon());
        System.out.println("JVM will now wait for the worker thread to finish before exiting.");
    }
}
