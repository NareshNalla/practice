package com.naresh.a_dsalgo.ag_heap.problems;

import java.util.PriorityQueue;

public class KthLargestStream {
    private int k;
    private PriorityQueue<Integer> minHeap;
    //min-heap: root = smallest = kth largest

    public KthLargestStream(int k, int[] nums){
        this.k = k;
        minHeap = new PriorityQueue<>();
        for( int n: nums) {
            add(n);
        }
    }
    public int add(int val){
        minHeap.offer(val); // O(log k)
        if(minHeap.size() > k){
            minHeap.poll(); //evict smallest
        }
        return minHeap.peek(); //kth largest get
    }
}
