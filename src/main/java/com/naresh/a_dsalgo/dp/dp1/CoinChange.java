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
        return dp[amount] > amount ? -1 : dp[amount];
    }
    // FAANG Tip: Initializing with 'amount + 1' is cleaner than Integer.MAX_VALUE to avoid overflow during '1 + dp[i-coin]'.
}
