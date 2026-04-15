package com.naresh.b_concepts.mt.create.thread;

import java.util.concurrent.*;

public class Way5_ScheduledExecutorService {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // One-time delayed task
        scheduler.schedule(() ->
            System.out.println("Way 5a: Delayed task - " + Thread.currentThread().getName()),
            2, TimeUnit.SECONDS
        );

        // Periodic task (every 1 sec after 1 sec initial delay)
        ScheduledFuture<?> periodic = scheduler.scheduleAtFixedRate(() ->
            System.out.println("Way 5b: Periodic task - " + Thread.currentThread().getName()),
            1, 1, TimeUnit.SECONDS
        );

        Thread.sleep(4000);
        periodic.cancel(false);
        scheduler.shutdown();
    }
}