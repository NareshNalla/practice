package com.naresh.a_dsalgo.greedy.problems;

import java.util.Arrays;

/**
 * Problem: Maximum Subarray (LeetCode 53)
 * Description: Find the contiguous subarray within an array of numbers that has the largest sum.
 */
public class MaximumSubarray {

    /**
     * Algorithm: Kadane's Algorithm. Iterate through the array, maintaining `currentMax` (max sum ending at current pos)
     * and `globalMax` (overall max sum). `currentMax` is either current element or current element + previous `currentMax`.
     *
     * @param nums An array of integers.
     * @return The sum of the contiguous subarray with the largest sum.
     */
    public int maxSubArray(int[] nums) {
        // Pattern: Kadane's Algorithm (Greedy/DP) | Time: O(N), Space: O(1)
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("Input array cannot be null or empty.");

        var globalMax = nums[0];    // Overall maximum sum found
        var currentMax = nums[0];   // Maximum sum ending at the current position

        for (var i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]); // Extend or start new subarray
            globalMax = Math.max(globalMax, currentMax); // Update overall max
        }
        return globalMax;
    }
    // FAANG Tip: Kadane's is a fundamental greedy/DP algorithm. Explain why local optimum (currentMax) leads to global optimum (globalMax).

    public static void main(String[] args) {
        var solution = new MaximumSubarray();

        var nums1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Nums: " + Arrays.toString(nums1) + " -> Max Subarray Sum: " + solution.maxSubArray(nums1)); // Expected: 6

        var nums2 = new int[]{1, 2, 3, 4, 5};
        System.out.println("Nums: " + Arrays.toString(nums2) + " -> Max Subarray Sum: " + solution.maxSubArray(nums2)); // Expected: 15

        var nums3 = new int[]{-1, -2, -3, -4, -5};
        System.out.println("Nums: " + Arrays.toString(nums3) + " -> Max Subarray Sum: " + solution.maxSubArray(nums3)); // Expected: -1

        var nums4 = new int[]{5, 4, -1, 7, 8};
        System.out.println("Nums: " + Arrays.toString(nums4) + " -> Max Subarray Sum: " + solution.maxSubArray(nums4)); // Expected: 23

        var nums5 = new int[]{10};
        System.out.println("Nums: " + Arrays.toString(nums5) + " -> Max Subarray Sum: " + solution.maxSubArray(nums5)); // Expected: 10

        var nums6 = new int[]{-7};
        System.out.println("Nums: " + Arrays.toString(nums6) + " -> Max Subarray Sum: " + solution.maxSubArray(nums6)); // Expected: -7
    }
}
