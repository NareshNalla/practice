package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: Maximum Subarray (Kadane's Algorithm)
 * Description: Find the contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 */
public class MaxSubArraySum {
    /**
     * Algorithm: Iterate through the array, keeping track of the current subarray sum. If current sum becomes negative, reset it.
     */
    public int maxSubArray(int[] nums) {
        // Pattern: Kadane's Algorithm | Time: O(n), Space: O(1)
        var maxSoFar = nums[0];
        var currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]); // Extend or start new
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }
    // FAANG Tip: This is a classic example of DP where we only need the previous state, thus O(1) space.
}
