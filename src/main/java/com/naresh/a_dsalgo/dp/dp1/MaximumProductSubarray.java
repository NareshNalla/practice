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
        var result = nums[0];
        var minEndingHere = nums[0];
        var maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            var tempMax = Math.max(nums[i], Math.max(maxEndingHere * nums[i], minEndingHere * nums[i]));
            minEndingHere = Math.min(nums[i], Math.min(maxEndingHere * nums[i], minEndingHere * nums[i]));
            maxEndingHere = tempMax;
            result = Math.max(result, maxEndingHere);
        }
        return result;
    }

    public static void main(String[] args) {
        var nums = new int[]{2,3,-2,4};
        var result = new MaximumProductSubarray().maxProduct(nums);
        System.out.println("Max product: " + result);
    }

    /*
     * Dry Run:
     * Input: nums = {2,3,-2,4}
     * 1. Initialize max/min/current = 2
     * 2. i=1 (3): update maxEndingHere=6, minEndingHere=3, maxSoFar=6
     *    i=2 (-2): swap signs -> maxEndingHere = max(-2, 6*-2, 3*-2) = -2? but min becomes -12 etc. final maxSoFar=6
     * 3. Result: 6
     */
    // FAANG Tip: The key insight is that a negative number can turn a very small product into a very large one.
}
