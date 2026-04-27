package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: Best Time to Buy and Sell Stock
 * Description: Find the maximum profit from buying and selling a stock once.
 */
public class MaxProfitStockBuySingle {
    /**
     * Algorithm: Track minimum price seen so far and calculate potential profit at each step.
     */
    public int maxProfit(int[] prices) {
        // Pattern: One-pass Greedy/DP | Time: O(n), Space: O(1)
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
    // FAANG Tip: This is essentially a 1D DP problem optimized to O(1) space.
}
