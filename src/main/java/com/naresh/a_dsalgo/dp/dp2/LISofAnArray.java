package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Longest Increasing Subsequence (LIS)
 * Description: Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */
public class LISofAnArray {
    /**
     * Algorithm: Binary search based approach (Patience Sorting). Maintain an array 'tails' where tails[i] is the smallest tail of all increasing subsequences of length i+1.
     */
    public int lengthOfLIS(int[] nums) {
        // Pattern: Binary Search / Patience Sorting | Time: O(n log n), Space: O(n)
        if (nums == null || nums.length == 0) return 0;
        var tails = new int[nums.length];
        var size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                var m = (i + j) / 2;
                if (tails[m] < x) i = m + 1;
                else j = m;
            }
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }
    // FAANG Tip: While O(n^2) DP is easier to come up with, the O(n log n) solution is the gold standard for this problem.

    public static void main(String[] args) {
        var nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        var result = new LISofAnArray().lengthOfLIS(nums);
        System.out.println("LIS length: " + result); // Output: 4 (sequence: 2,3,7,101 or 2,3,7,18)
    }

    /*
     * Dry Run:
     * Input: nums = {10,9,2,5,3,7,101,18}
     * tails tracking (binary search):
     * 10 -> tails=[10], size=1
     * 9 -> tails=[9], size=1
     * 2 -> tails=[2], size=1
     * 5 -> tails=[2,5], size=2
     * 3 -> tails=[2,3], size=2
     * 7 -> tails=[2,3,7], size=3
     * 101 -> tails=[2,3,7,101], size=4
     * Result: 4
     */
}
