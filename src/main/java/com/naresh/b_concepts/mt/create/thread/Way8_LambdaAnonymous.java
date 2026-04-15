package com.naresh.b_concepts.mt.create.thread;

public class Way8_LambdaAnonymous {
    public static void main(String[] args) {
        // Anonymous class
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Way 8a: Anonymous Runnable - " + Thread.currentThread().getName());
            }
        });

        // Lambda (Java 8+)
        Thread t2 = new Thread(() ->
            System.out.println("Way 8b: Lambda Runnable - " + Thread.currentThread().getName())
        );

        t1.start();
        t2.start();
    }
}