package com.naresh.b_concepts.mt.create.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Way4_ExecutorService {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() ->
                System.out.println("Way 4: ExecutorService Task-" + taskId
                    + " - " + Thread.currentThread().getName())
            );
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
    //newFixedThreadPool, newCachedThreadPool,
    // newSingleThreadExecutor, newScheduledThreadPool
}