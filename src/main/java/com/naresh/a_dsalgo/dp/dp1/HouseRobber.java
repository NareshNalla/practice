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
        int rob1 = 0, rob2 = 0;
        for (int n : nums) {
            var temp = Math.max(n + rob1, rob2); // Choice: rob current vs skip
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
    // FAANG Tip: Space optimization from O(n) to O(1) is a common follow-up. Highlight the recurrence relation: f(i) = max(f(i-1), f(i-2) + nums[i]).
}
