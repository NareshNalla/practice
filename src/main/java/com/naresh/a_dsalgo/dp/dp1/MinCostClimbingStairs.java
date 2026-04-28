package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: Min Cost Climbing Stairs
 * Description: You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 */
public class MinCostClimbingStairs {
    /**
     * Algorithm: Iterative DP with two variables. cost to reach i is current cost + min of previous two costs.
     */
    public int minCostClimbingStairs(int[] cost) {
        // Pattern: DP (Space Optimized) | Time: O(n), Space: O(1)
        int down1 = 0, down2 = 0;
        for (int i = 2; i <= cost.length; i++) {
            var temp = Math.min(down1 + cost[i - 1], down2 + cost[i - 2]);
            down2 = down1;
            down1 = temp;
        }
        return down1;
    }
    // FAANG Tip: We only need the costs to reach the last two steps. Space optimization from O(n) to O(1) is expected.
}
