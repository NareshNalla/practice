package com.naresh.a_dsalgo.greedy.problems;

import java.util.Arrays;

/**
 * Problem: Maximum Subarray (LeetCode 53)
 * Description: Find the contiguous subarray within an array of numbers that has the largest sum.
 */
public class MaximumSubarray {

    /**
     * Algorithm: Kadane's Algorithm variant. Iterate through the array, maintaining `currentSum`
     * (sum of current subarray) and `maxNum` (overall maximum sum found). If `currentSum` becomes
     * negative, reset it to 0 (effectively starting a new subarray). Update `maxNum` at each step.
     *
     * @param nums An array of integers.
     * @return The sum of the contiguous subarray with the largest sum.
     */
    public int maxSubArray(int[] nums) {
        // Pattern: Kadane's Algorithm (Greedy/DP) | Time: O(N), Space: O(1)
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("Input array cannot be null or empty.");

        var currentSum = 0; // Sum of the current subarray being considered
        var maxNum = nums[0]; // Overall maximum sum found so far

        for (var i = 0; i < nums.length; i++) {
            if (currentSum < 0) { // If current sum is negative, it won't help future sums
                currentSum = 0; // Reset current sum, effectively starting a new subarray
            }
            currentSum += nums[i]; // Add current element to current sum
            maxNum = Math.max(maxNum, currentSum); // Update overall maximum sum
        }
        return maxNum;
    }
    // FAANG Tip: This variant of Kadane's algorithm is intuitive: if a subarray sum turns negative, it's better to discard it and start fresh.

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
