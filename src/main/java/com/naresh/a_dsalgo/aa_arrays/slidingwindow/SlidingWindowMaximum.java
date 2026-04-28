package com.naresh.a_dsalgo.aa_arrays.slidingwindow;

import java.util.*;

/**
 * Problem: Sliding Window Maximum
 * Description: Given an array nums and a sliding window of size k, return the maximum element in each window.
 */
public class SlidingWindowMaximum {
    /**
     * Algorithm: Use a Monotonic Deque to store indices. Maintain deque in decreasing order of values. 
     * The head of the deque always contains the index of the maximum element for the current window.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Pattern: Monotonic Deque | Time: O(n), Space: O(k)
        if (nums == null || nums.length == 0) return new int[0];
        var n = nums.length;
        var res = new int[n - k + 1];
        var dq = new ArrayDeque<Integer>(); // Stores indices

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst(); // Remove out-of-bounds
            
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast(); // Maintain monotonic property
            
            dq.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()]; // Max is at the front
        }
        return res;
    }
    // FAANG Tip: Monotonic Queue/Deque is a powerful pattern for window-based extrema. Amortized time is O(n) as each index is pushed/popped once.

    public static void main(String[] args) {
        var sol = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))); // Expected: [3, 3, 5, 5, 6, 7]
        System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[]{1}, 1))); // Expected: [1]
    }
}
