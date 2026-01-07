package com.naresh.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WorkerTask implements Runnable {
    private final int taskId;

    public WorkerTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is being executed by " + Thread.currentThread().getName());
        try {
            // Simulate some work
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " completed.");
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Why use an ExecutorService (Thread Pool)?
        // 1. Performance: Reusing existing threads is much faster than creating new ones for every task.
        // 2. Resource Management: It limits the number of concurrent threads, preventing the system
        //    from being overloaded and running out of memory or CPU resources.
        // 3. Simplicity: It provides a higher-level API for managing concurrent tasks.

        // Create a thread pool with a fixed number of threads (e.g., 3)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 10 tasks to the thread pool.
        // The executor service will manage running these tasks on its 3 available threads.
        for (int i = 1; i <= 10; i++) {
            executor.submit(new WorkerTask(i));
        }

        // It's a best practice to shut down the executor service when it's no longer needed.
        // shutdown() will wait for all submitted tasks to finish before terminating the threads.
        executor.shutdown();

        try {
            // Wait for all tasks to complete before moving on.
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Force shutdown if tasks don't complete in time
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks have been completed.");
    }
}
