package com.naresh.a_dsalgo.ag_heap.problems;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Support addNum() and findMedian() on a live stream. The median is the middle value of all numbers so far.
Time: O(log n) add · O(1) median  Space: O(n)
 */
public class FindMedianInStream {
    //lo = max-heap -> holds the Smaller half
    PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
    //hi = min-heap -> Holds the Largest half
    PriorityQueue<Integer> hi = new PriorityQueue<>();

    public void addNum(int num){
        lo.offer(num); // always insert into lo first
        hi.offer(lo.poll()); //push lo's max up -> keeps hi valid
        if(hi.size() > lo.size()){
            lo.offer(hi.poll());
        }
    }
    public double findMedian(){
        return lo.size() > hi.size()?
                lo.peek()
                :(lo.peek() + hi.peek())/2.0;
    }

    public static void main(String[] args) {
        FindMedianInStream medianFinder = new FindMedianInStream();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median after [1, 2]: " + medianFinder.findMedian()); // Expected: 1.5
        medianFinder.addNum(3);
        System.out.println("Median after [1, 2, 3]: " + medianFinder.findMedian()); // Expected: 2.0
        medianFinder.addNum(4);
        System.out.println("Median after [1, 2, 3, 4]: " + medianFinder.findMedian()); // Expected: 2.5
    }
}
