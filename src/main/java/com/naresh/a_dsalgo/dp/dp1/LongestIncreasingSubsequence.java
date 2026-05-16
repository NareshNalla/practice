package com.naresh.a_dsalgo.dp.dp1;

// removed unused import

/**
 * Problem: Longest Increasing Subsequence
 * Description: Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */
public class LongestIncreasingSubsequence {
    /**
     * Algorithm: Patient sorting approach using binary search to maintain a tail array.
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
            tails[i] = x; // Update tail of LIS with length i+1
            if (i == size) size++;
        }
        return size;
    }

    public static void main(String[] args) {
        var nums = new int[]{10,9,2,5,3,7,101,18};
        var result = new LongestIncreasingSubsequence().lengthOfLIS(nums);
        System.out.println("LIS length: " + result);
    }

    /*
     * Dry Run:
     * Input: nums = {10,9,2,5,3,7,101,18}
     *
     * Brief trace (tails updates):
     * tails after processing 10 -> [10]
     * after 9 -> [9]
     * after 2 -> [2]
     * after 5 -> [2,5]
     * after 3 -> [2,3]
     * after 7 -> [2,3,7]
     * after 101 -> [2,3,7,101]
     * after 18 -> [2,3,7,18]
     * Result: size = 4
     */
    // FAANG Tip: While O(n^2) DP is common, FAANG interviews often expect the O(n log n) binary search optimization.
}
