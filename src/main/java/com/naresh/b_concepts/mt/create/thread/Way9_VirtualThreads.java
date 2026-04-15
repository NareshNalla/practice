package com.naresh.b_concepts.mt.create.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Way9_VirtualThreads {

    public static void main(String[] args) throws InterruptedException {

        // --- 9a: Direct virtual thread ---
        Thread vt = Thread.ofVirtual()
                .name("my-virtual-thread")
                .start(() ->
                    System.out.println("Way 9a: Virtual Thread - " + Thread.currentThread())
                );
        vt.join();

        // --- 9b: Virtual thread per task ExecutorService ---
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 5; i++) {
                final int taskId = i;
                executor.submit(() ->
                    System.out.println("Way 9b: VirtualThread Task-" + taskId
                        + " - " + Thread.currentThread())
                );
            }
        } // auto shutdown (try-with-resources)

        // --- 9c: Thread.ofVirtual builder (unstarted) ---
        Thread unstarted = Thread.ofVirtual()
                .name("unstarted-vt")
                .unstarted(() ->
                    System.out.println("Way 9c: Unstarted Virtual Thread - " + Thread.currentThread())
                );
        unstarted.start();
        unstarted.join();
    }
}