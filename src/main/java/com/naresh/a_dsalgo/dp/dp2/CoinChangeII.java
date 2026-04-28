package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Coin Change II (Number of Ways to Make Change)
 * Description: Given an amount and a list of coins, return the number of combinations that sum up to the amount.
 */
public class CoinChangeII {
    /**
     * Algorithm: DP. `dp[i]` represents the number of ways to make amount `i`. Iterate through coins, then amounts.
     */
    public int change(int amount, int[] coins) {
        // Pattern: DP (1D, Unbounded Knapsack) | Time: O(amount * num_coins), Space: O(amount)
        var dp = new int[amount + 1];
        dp[0] = 1; // One way to make amount 0 (by choosing no coins)
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin]; // Add ways to make (i - coin)
            }
        }
        return dp[amount];
    }
    // FAANG Tip: The order of loops (coins then amounts) is crucial to count combinations, not permutations.
}
