package com.naresh.a_dsalgo.dp.dp1;

import java.util.*;

/**
 * Problem: Partition Equal Subset Sum
 * Description: Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 */
public class PartitionEqualSubsetSum {
    /**
     * Algorithm: This is a 0/1 Knapsack variation. Find if any subset sums to totalSum / 2.
     */
    public boolean canPartition(int[] nums) {
        // Pattern: DP (Set-based) | Time: O(n * sum), Space: O(sum)
        var sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false; // Odd sum cannot be split
        
        var target = sum / 2;
        var dp = new boolean[target + 1];
        dp[0] = true; // Base case: sum 0 is always possible
        
        for (int num : nums) {
            for (int i = target; i >= num; i--) { // Traverse backwards to avoid re-using current element
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
    // FAANG Tip: 1D array DP (traversed backwards) reduces space complexity from O(n * sum) to O(sum).
}
