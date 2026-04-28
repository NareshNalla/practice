package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Target Sum
 * Description: You are given an integer array nums and an integer target. Build an expression by adding a '+' or '-' before each integer and return the number of different expressions that evaluate to target.
 */
public class TargetSum {
    /**
     * Algorithm: Reduce to Partition Equal Subset Sum problem. Let P be subset with '+', N be subset with '-'.
     * P - N = target AND P + N = sum => 2P = target + sum => P = (target + sum) / 2.
     */
    public int findTargetSumWays(int[] nums, int target) {
        // Pattern: DP (Subset Sum) | Time: O(n * sum), Space: O(sum)
        var sum = 0;
        for (int n : nums) sum += n;
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;
        
        var subsetTarget = (sum + target) / 2;
        var dp = new int[subsetTarget + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = subsetTarget; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[subsetTarget];
    }
    // FAANG Tip: Transforming the problem into a simpler one (Subset Sum) is a highly valued skill in interviews.
}
