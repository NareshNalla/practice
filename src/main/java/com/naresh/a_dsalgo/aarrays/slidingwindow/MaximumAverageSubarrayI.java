package com.naresh.a_dsalgo.aarrays.slidingwindow;

/**
 * Problem: Maximum Average Subarray I
 * Description: Find a contiguous subarray of given length k that has the maximum average value.
 */
public class MaximumAverageSubarrayI {
    /**
     * Algorithm: Use a fixed-size sliding window. Calculate the sum of the first k elements.
     * Then, slide the window one element at a time, subtracting the element leaving the window
     * and adding the element entering the window. Keep track of the maximum sum encountered.
     */
    public double findMaxAverage(int[] nums, int k) {
        // Pattern: Sliding Window | Time: O(n), Space: O(1)
        if (nums == null || nums.length < k) return 0.0; // Edge case: invalid input
        long currentWindowSum = 0; // Use long to prevent potential overflow for sum
        // Calculate sum of the first window
        for (int i = 0; i < k; i++) {
            currentWindowSum += nums[i];
        }
        long maxSum = currentWindowSum; // Initialize maxSum with the first window's sum
        // Slide the window
        for (int i = k; i < nums.length; i++) {
            currentWindowSum += nums[i] - nums[i - k]; // Add new element, subtract old
            maxSum = Math.max(maxSum, currentWindowSum); // Update max sum
        }

        return (double) maxSum / k; // Calculate and return the maximum average
    }
    // FAANG Tip: Emphasize the efficiency of the sliding window for fixed-size subarrays (O(n) vs O(n*k) brute force). Mention using 'long' for sum to prevent overflow.

    public static void main(String[] args) {
        var sol = new MaximumAverageSubarrayI();

        // Test Case 1
        var nums1 = new int[]{1, 12, -5, -6, 50, 3};
        var k1 = 4;
        System.out.println("Nums: " + java.util.Arrays.toString(nums1) + ", k: " + k1 + " -> Max Average: " + sol.findMaxAverage(nums1, k1)); // Expected: 12.75

        // Test Case 2
        var nums2 = new int[]{5};
        var k2 = 1;
        System.out.println("Nums: " + java.util.Arrays.toString(nums2) + ", k: " + k2 + " -> Max Average: " + sol.findMaxAverage(nums2, k2)); // Expected: 5.0

        // Test Case 3
        var nums3 = new int[]{0, 1, 1, 3, 3};
        var k3 = 4;
        System.out.println("Nums: " + java.util.Arrays.toString(nums3) + ", k: " + k3 + " -> Max Average: " + sol.findMaxAverage(nums3, k3)); // Expected: 2.0
    }
}
