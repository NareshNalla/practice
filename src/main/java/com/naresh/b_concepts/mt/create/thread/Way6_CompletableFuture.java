package com.naresh.b_concepts.mt.create.thread;

import java.util.concurrent.CompletableFuture;

public class Way6_CompletableFuture {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Way 6: CompletableFuture - " + Thread.currentThread().getName());
            return "Hello from async";
        }).thenApply(result -> result + " -> chained!");

        System.out.println(future.get());
    }
}