package com.naresh.b_concepts.mt.create.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Way3_CallableFutureTask {
    public static void main(String[] args) throws Exception {
        Callable<String> callable = () -> {
            System.out.println("Way 3: Callable - " + Thread.currentThread().getName());
            return "Result from Callable";
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();

        // Blocks until result is ready
        String result = futureTask.get();
        System.out.println("Got: " + result);
    }
}