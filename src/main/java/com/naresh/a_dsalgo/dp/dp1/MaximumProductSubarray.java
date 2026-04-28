package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: Maximum Product Subarray
 * Description: Find the contiguous subarray within an array of numbers that has the largest product.
 */
public class MaximumProductSubarray {
    /**
     * Algorithm: Track both max and min product ending at current position due to negative numbers.
     */
    public int maxProduct(int[] nums) {
        // Pattern: DP (Two States) | Time: O(n), Space: O(1)
        if (nums.length == 0) return 0;
        var maxSoFar = nums[0];
        var minEndingHere = nums[0];
        var maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            var tempMax = Math.max(nums[i], Math.max(maxEndingHere * nums[i], minEndingHere * nums[i]));
            minEndingHere = Math.min(nums[i], Math.min(maxEndingHere * nums[i], minEndingHere * nums[i]));
            maxEndingHere = tempMax;
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    // FAANG Tip: The key insight is that a negative number can turn a very small product into a very large one.
}
