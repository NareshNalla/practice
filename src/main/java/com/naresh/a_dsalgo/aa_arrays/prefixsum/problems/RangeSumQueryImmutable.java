package com.naresh.a_dsalgo.aa_arrays.prefixsum.problems;

import java.util.Arrays;

/**
 * Range Sum Query - Immutable
 * 
 * Approach: Prefix Sum
 * Time Complexity: 
 *   - Constructor: O(N) to precompute the prefix sums
 *   - sumRange: O(1) for each query
 * Space Complexity: O(N) to store the prefix sum array
 */
class NumArray {
    private final int[] prefixSums;

    public NumArray(int[] nums) {
        // We use an array of size n + 1 to handle the prefix sum starting from index 0 easily.
        // prefixSums[i] will store the sum of elements from nums[0] to nums[i-1].
        int n = nums.length;
        prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }

    /**
     * Returns the sum of elements between indices left and right (inclusive).
     * Formula: Sum(left, right) = prefixSums[right + 1] - prefixSums[left]
     */
    public int sumRange(int left, int right) {
        // Basic boundary checks (optional depending on interview constraints)
        if (left < 0 || right >= prefixSums.length - 1 || left > right) {
            return 0;
        }
        return prefixSums[right + 1] - prefixSums[left];
    }
}

public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("sumRange(0, 2): " + numArray.sumRange(0, 2)); // Expected: 1 (-2 + 0 + 3)
        System.out.println("sumRange(2, 5): " + numArray.sumRange(2, 5)); // Expected: -1 (3 + -5 + 2 + -1)
        System.out.println("sumRange(0, 5): " + numArray.sumRange(0, 5)); // Expected: -3
    }
}
