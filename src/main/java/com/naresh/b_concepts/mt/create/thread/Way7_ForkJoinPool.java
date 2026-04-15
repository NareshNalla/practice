package com.naresh.b_concepts.mt.create.thread;

import java.util.concurrent.*;

public class Way7_ForkJoinPool extends RecursiveTask<Long> {
    private final long n;

    public Way7_ForkJoinPool(long n) { this.n = n; }

    @Override
    protected Long compute() {
        System.out.println(n);
        if (n <= 1) return n;
        Way7_ForkJoinPool f1 = new Way7_ForkJoinPool(n - 1);
        f1.fork(); // async
        return n + f1.join(); // sum 1..n
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        long result = pool.invoke(new Way7_ForkJoinPool(10));
        System.out.println("Way 7: ForkJoinPool sum = " + result);
    }
}