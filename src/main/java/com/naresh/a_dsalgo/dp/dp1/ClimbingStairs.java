package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: Climbing Stairs
 * Description: You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    /**
     * Algorithm: Use iterative DP with two variables to track ways to reach the previous two steps.
     */
    public int climbStairs(int n) {
        // Pattern: DP (Space Optimized) | Time: O(n), Space: O(1)
        if (n <= 2) return n;
        var first = 1; var second = 2;
        for (int i = 3; i <= n; i++) {
            var third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
    // FAANG Tip: This is essentially the Fibonacci sequence. O(1) space is expected for this problem.
}
