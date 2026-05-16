package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: House Robber
 * Description: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * Constraint: You cannot rob two adjacent houses.
 */
public class HouseRobber {
    /**
     * Algorithm: Iterative DP with two variables. For each house, decide whether to rob it (nums[i] + rob_i-2) or skip it (rob_i-1).
     */
    public int rob(int[] nums) {
        // Pattern: DP (Space Optimized) | Time: O(n), Space: O(1)
        int rob1 = 0, rob2 = 0; // Max robbed up to previous two houses
        for (int n : nums) {
            var temp = Math.max(n + rob1, rob2); // Max of robbing current or skipping
            rob1 = rob2; // Update rob1 to previous rob2
            rob2 = temp; // Update rob2 to new max
        }
        return rob2; // Max amount robbed
    }
    // FAANG Tip: Space optimization from O(n) to O(1) is a common follow-up. Highlight the recurrence relation: f(i) = max(f(i-1), f(i-2) + nums[i]).

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 1};
        var result = new HouseRobber().rob(nums);
        System.out.println("Max robbed: " + result);
    }

    /**
     * Dry Run:
     * Input: nums = {1, 2, 3, 1}
     *
     * 1. Initialization:
     *    rob1 = 0, rob2 = 0
     *
     * 2. Loop Iterations:
     *    n = 1: temp = max(1 + 0, 0) = 1, rob1 = 0, rob2 = 1
     *    n = 2: temp = max(2 + 0, 1) = 2, rob1 = 1, rob2 = 2
     *    n = 3: temp = max(3 + 1, 2) = 4, rob1 = 2, rob2 = 4
     *    n = 1: temp = max(1 + 2, 4) = 4, rob1 = 4, rob2 = 4
     *
     * 3. Result: 4
     */
}
