package com.naresh.a_dsalgo.ag_heap.problems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem: Find Median in Data Stream (LeetCode 295)
 * Description: Design a data structure that supports adding new numbers and finding the median of all numbers so far.
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no single
 * middle value, and the median is the average of the two middle values.
 */
public class FindMedianInStream {
    // `lo` is a max-heap storing the smaller half of numbers. Its top is the largest element in the smaller half.
    private final PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
    // `hi` is a min-heap storing the larger half of numbers. Its top is the smallest element in the larger half.
    private final PriorityQueue<Integer> hi = new PriorityQueue<>();

    /**
     * Algorithm: Maintain two heaps: a max-heap (`lo`) for the smaller half and a min-heap (`hi`) for the larger half.
     * Ensure `lo.size() >= hi.size()` and `lo.peek() <= hi.peek()`.
     * Add `num` to `lo`, then move `lo.peek()` to `hi`. If `hi` becomes larger, move `hi.peek()` to `lo`.
     *
     * @param num The number to add to the data stream.
     */
    public void addNum(int num) {
        // Pattern: Two Heaps | Time: O(log N), Space: O(N)
        lo.offer(num); // Always add to max-heap first
        hi.offer(lo.poll()); // Move largest from lo to min-heap hi (maintains hi > lo)
        if (hi.size() > lo.size()) lo.offer(hi.poll()); // Balance: ensure lo.size() >= hi.size()
    }
    // FAANG Tip: Two heaps (max-heap for smaller half, min-heap for larger half) is the standard approach. Balancing ensures O(1) median access.

    /**
     * Algorithm: If `lo` has more elements, its peek is the median. If sizes are equal,
     * the median is the average of `lo.peek()` and `hi.peek()`.
     *
     * @return The median of all numbers added so far.
     */
    public double findMedian() {
        // Pattern: Two Heaps | Time: O(1), Space: O(1)
        return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) / 2.0; // Return median based on sizes
    }
    // FAANG Tip: The balancing logic in addNum guarantees that median is always at the top of heaps or average of their tops.

    public static void main(String[] args) {
        var medianFinder = new FindMedianInStream();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median after [1, 2]: " + medianFinder.findMedian()); // Expected: 1.5
        medianFinder.addNum(3);
        System.out.println("Median after [1, 2, 3]: " + medianFinder.findMedian()); // Expected: 2.0
        medianFinder.addNum(4);
        System.out.println("Median after [1, 2, 3, 4]: " + medianFinder.findMedian()); // Expected: 2.5
        medianFinder.addNum(5);
        System.out.println("Median after [1, 2, 3, 4, 5]: " + medianFinder.findMedian()); // Expected: 3.0
        medianFinder.addNum(0);
        System.out.println("Median after [0, 1, 2, 3, 4, 5]: " + medianFinder.findMedian()); // Expected: 2.5
    }
}
