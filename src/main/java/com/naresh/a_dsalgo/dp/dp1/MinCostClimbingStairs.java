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
        int down1 = 0, down2 = 0; // Costs to reach last two steps
        for (int i = 2; i <= cost.length; i++) {
            var temp = Math.min(down1 + cost[i - 1], down2 + cost[i - 2]); // Min cost to reach step i
            down2 = down1; // Shift down2 to previous down1
            down1 = temp; // Update down1 to new min cost
        }
        return down1; // Min cost to reach top
    }
    // FAANG Tip: We only need the costs to reach the last two steps. Space optimization from O(n) to O(1) is expected.

    public static void main(String[] args) {
        var cost = new int[]{10, 15, 20};
        var result = new MinCostClimbingStairs().minCostClimbingStairs(cost);
        System.out.println("Min cost: " + result);
    }

    /**
     * Dry Run:
     * Input: cost = {10, 15, 20}
     *
     * 1. Initialization:
     *    down1 = 0, down2 = 0
     *
     * 2. Loop Iterations:
     *    i = 2: temp = min(0 + 15, 0 + 10) = min(15, 10) = 10, down2 = 0, down1 = 10
     *    i = 3: temp = min(10 + 20, 0 + 15) = min(30, 15) = 15, down2 = 10, down1 = 15
     *
     * 3. Result: 15
     */
}
