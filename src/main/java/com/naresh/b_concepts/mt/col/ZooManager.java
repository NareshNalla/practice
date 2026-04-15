package com.naresh.b_concepts.mt.col;

import java.util.*;
import java.util.concurrent.*;

public class ZooManager {

    public static void main(String[] args) {
        ZooManager manager = new ZooManager();

        System.out.println("--- 1. HashMap Modification (Expected Exception) ---");
        manager.demoHashMapModificationException();

        System.out.println("\n--- 2. Concurrent Collections (Map, Queue, Deque) ---");
        manager.demoConcurrentCollections();

        System.out.println("\n--- 3. Blocking Queue ---");
        manager.demoBlockingQueue();

        System.out.println("\n--- 4. Blocking Deque ---");
        manager.demoBlockingDeque();

        System.out.println("\n--- 5. CopyOnWriteArrayList ---");
        manager.demoCopyOnWriteArrayList();

        System.out.println("\n--- 6. Synchronized Collections ---");
        manager.synchronizedFoodData();
    }

    public void demoHashMapModificationException() {
        try {
            Map<String, Object> foodData = new HashMap<>();
            foodData.put("penguin", 1);
            foodData.put("flamingo", 2);
            for (String key : foodData.keySet())
                foodData.remove(key); // This will throw ConcurrentModificationException
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught expected: " + e);
        }
    }

    public void demoConcurrentCollections() {
        Map<String, Object> foodData = new ConcurrentHashMap<>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key : foodData.keySet())
            foodData.remove(key); // Safe with ConcurrentHashMap
        System.out.println("ConcurrentHashMap processed successfully.");

        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        System.out.println("Map Get Elephant: " + map.get("elephant"));

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println("Queue Peek: " + queue.peek());
        System.out.println("Queue Poll: " + queue.poll());

        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);
        deque.push(4);
        System.out.println("Deque Peek: " + deque.peek());
        System.out.println("Deque Pop: " + deque.pop());
    }

    public void demoBlockingQueue() {
        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);
            System.out.println("BlockingQueue Poll 1: " + blockingQueue.poll());
            System.out.println("BlockingQueue Poll 2: " + blockingQueue.poll(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void demoBlockingDeque() {
        try {
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);
            System.out.println("BlockingDeque Poll: " + blockingDeque.poll());
            System.out.println("BlockingDeque Poll (Wait): " + blockingDeque.poll(950, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void demoCopyOnWriteArrayList() {
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
        for (Integer item : list) {
            System.out.print(item + " ");
            list.add(9);
        }
        System.out.println("\nSize after concurrent adds: " + list.size());
    }

    public void synchronizedFoodData() {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>(Arrays.asList(4, 3, 52)));
        synchronized (list) {
            for (int data : list)
                System.out.print(data + " ");
        }
        System.out.println();
    }
}