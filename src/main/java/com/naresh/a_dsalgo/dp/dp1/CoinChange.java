package com.naresh.a_dsalgo.dp.dp1;

import java.util.Arrays;

/**
 * Problem: Coin Change
 * Description: Find the fewest number of coins that you need to make up a given amount.
 */
public class CoinChange {
    /**
     * Algorithm: Bottom-up DP. For each amount up to target, try every coin and update dp[amount] with min coins.
     */
    public int coinChange(int[] coins, int amount) {
        // Pattern: DP (1D) | Time: O(n * amount), Space: O(amount)
        var dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Fill with value greater than possible
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]); // Transition
                }
            }
        }
        return dp[amount] < (amount + 1) ? dp[amount] : -1;
    }
    // FAANG Tip: Initializing with 'amount + 1' is cleaner than Integer.MAX_VALUE to avoid overflow during '1 + dp[i-coin]'.

    public static void main(String[] args) {
        var coins = new int[]{1,2,5};
        var amount = 11;
        var result = new CoinChange().coinChange(coins, amount);
        System.out.println("Fewest coins for " + amount + ": " + result);
    }

    /*
     * Dry Run:
     * Input: coins = {1,2,5}, amount = 11
     *
     * 1. Initialization:
     *    dp = [0, 12, 12, ..., 12] (length 12), dp[0]=0
     * 2. Process amounts updating dp via coins; final dp[11] = 3 (5+5+1)
     * 3. Result: 3
     */
}
