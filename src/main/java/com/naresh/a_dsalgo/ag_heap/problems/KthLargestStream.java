package com.naresh.a_dsalgo.ag_heap.problems;

import java.util.PriorityQueue;
import java.util.Arrays; // For Arrays.toString in main method

/**
 * Problem: Kth Largest Element in a Stream (LeetCode 703)
 * Description: Design a class to find the k-th largest element in a stream.
 * Note that it is the k-th largest element in the sorted order, not the k-th distinct element.
 * The class should have a constructor that takes an integer `k` and an integer array `nums`,
 * which contains initial elements, and a method `add` that takes an integer `val`,
 * and returns the k-th largest element in the stream after adding `val`.
 */
public class KthLargestStream {
    private final int k;
    // A min-heap to store the 'k' largest elements. The root of this min-heap will be the k-th largest element.
    private final PriorityQueue<Integer> minHeap;

    /**
     * Algorithm: Initialize the min-heap with the given `nums` array. For each number,
     * add it to the heap and if the heap size exceeds `k`, remove the smallest element.
     * This ensures the heap always contains the `k` largest elements seen so far.
     *
     * @param k The desired k-th largest element.
     * @param nums An array of initial numbers in the stream.
     */
    public KthLargestStream(int k, int[] nums) {
        // Pattern: Min-Heap | Time: O(N log K), Space: O(K)
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (var n : nums) add(n); // Add initial numbers to the heap
    }
    // FAANG Tip: Constructor complexity is N log K because N elements are added, each taking log K time.

    /**
     * Algorithm: Add the new `val` to the min-heap. If the heap's size exceeds `k`,
     * remove the smallest element (heap's root). The heap's root will then be the k-th largest element.
     *
     * @param val The new integer to add to the stream.
     * @return The k-th largest element in the stream after adding `val`.
     */
    public int add(int val) {
        // Pattern: Min-Heap | Time: O(log K), Space: O(1) (relative to heap size K)
        minHeap.offer(val); // Add new value to min-heap
        if (minHeap.size() > k) minHeap.poll(); // If size exceeds k, remove smallest element
        return minHeap.peek(); // The root of the min-heap is the k-th largest
    }
    // FAANG Tip: Using a min-heap of size K is efficient. Each add/remove is log K.

    public static void main(String[] args) {
        var k = 3;
        var nums = new int[]{4, 5, 8, 2};
        var kthLargest = new KthLargestStream(k, nums);
        System.out.println("Initial nums: " + Arrays.toString(nums) + ", k: " + k);

        System.out.println("Add 3: " + kthLargest.add(3)); // Stream: [2,3,4,5,8], k-th largest: 4
        System.out.println("Add 5: " + kthLargest.add(5)); // Stream: [2,3,4,5,5,8], k-th largest: 5
        System.out.println("Add 10: " + kthLargest.add(10)); // Stream: [2,3,4,5,5,8,10], k-th largest: 5
        System.out.println("Add 9: " + kthLargest.add(9)); // Stream: [2,3,4,5,5,8,9,10], k-th largest: 8
        System.out.println("Add 4: " + kthLargest.add(4)); // Stream: [2,3,4,4,5,5,8,9,10], k-th largest: 8

        var kthLargest2 = new KthLargestStream(1, new int[]{});
        System.out.println("\nInitial nums: [], k: 1");
        System.out.println("Add -3: " + kthLargest2.add(-3)); // Expected: -3
        System.out.println("Add -2: " + kthLargest2.add(-2)); // Expected: -2
        System.out.println("Add -4: " + kthLargest2.add(-4)); // Expected: -2
    }
}
