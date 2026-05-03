package com.naresh;
import  java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

public class DailyType {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        List<String> names = List.of("Naresh", "Nirva","Riya","Mouni");

        //Filter, transform, collect
        names.stream()
                .filter(n -> n.startsWith("N"))
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println(names);
        //groupping
        Map<Integer, List<String>> byLength = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(byLength);

        //joined
        String joined = names.stream()
                .collect(Collectors.joining(",","[","]"));

        System.out.println(joined);

        //record java 16+
        record Person(String name, int age){
            Person{
                if(age<18) throw new IllegalArgumentException("age<0");
            }
        }
        var person = new Person("Naresh", 35);
        //var person1 = new Person("Test", 0);
        System.out.println(person.name()); //not getName()
        //System.out.println(person1);
        
        //SEALED class and pattern matching (Java 21+)
        Shape shape = new Circle(5.0);
        if (shape instanceof Circle cir) {//java 17+
            System.out.println(shape);
        }
        double area = switch(shape){ //exhaustive - no default needed
            case Circle cir -> Math.PI * cir.r() * cir.r();
            case Rect rec -> rec.w * rec.h;
        };
        //completable futures
        CompletableFuture<String> cf1 =  CompletableFuture.supplyAsync(() ->"Nareesh");
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> "Engineer");


        String combined = cf1.thenCombine(cf2, (v, r) -> v + " is a"+ r).join();
        cf1.thenApply(String::length)
                .thenCompose(len -> CompletableFuture.supplyAsync(()->"len: "+len))
                .exceptionally(ex -> "error: "+ex.getMessage())
                .thenAccept(System.out::println);
        CompletableFuture.allOf(cf1, cf2).thenRun(() -> System.out.println("All Done"));


        //9. executor service
        ExecutorService fixed = Executors.newFixedThreadPool(4);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        Future<String> future = fixed.submit(() -> "task result");
        String taskResult = future.get(5, TimeUnit.SECONDS);
        List<Callable<String>> tasks = List.of(() -> "task1", () -> "task2", () -> "task3");
        String fastest = fixed.invokeAny(tasks);

        List<Future<String>> all = fixed.invokeAll(tasks);

        scheduler.schedule(() -> System.out.println("delayed 2s"), 2, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(() -> {}, 0, 1, TimeUnit.SECONDS);
        fixed.shutdown();
        scheduler.shutdown();
        //VIRTUAL THREADS
        try(var vExec = Executors.newVirtualThreadPerTaskExecutor()){
                for(int i= 0; i<3; i++){
                    int id = i;
                    vExec.submit(()-> System.out.println("virtual-"+id));
                }
        }//auto complete

    //concurency primitives
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for(int i=0; i < 3 ; i++){
            pool.submit(() -> {doWork(); latch.countDown();});
        }
        latch.await();
        System.out.println("All 3 workers Done");
        pool.shutdown();

        Semaphore sem = new Semaphore(5);
        sem.acquire();
        try{ accessResource(); } finally { sem.release(); }

        AtomicInteger counter = new AtomicInteger(0);
        counter.incrementAndGet();
        counter.compareAndSet(1,2);
        System.out.println(counter);

    }
    
    /**
     * Sealed Interface (Java 17+)
     * Only Circle and Rect can implement this interface.
     * This prevents unauthorized implementations and makes exhaustive switch cases possible.
     */
    sealed interface Shape permits Circle, Rect {}
    
    /**
     * Record (Java 16+) + Sealed Interface Implementation
     * Immutable data carrier with automatic equals, hashCode, toString
     */
    record Circle(double r) implements Shape {}
    
    record Rect(double w, double h) implements Shape {}

    static void doWork() {/* simulate work*/}
    static void accessResource() {/* shared resource*/}
}

/*
The error occurs because CompletableFuture.get() throws checked exceptions (InterruptedException, ExecutionException) which main doesn't handle. Options: catch those exceptions, declare main to throws, or use join() (unchecked)
 */