package com.naresh.a_dsalgo.aa_arrays.slidingwindow;

/**
 * Problem: Best Time to Buy and Sell Stock
 * Description: Find the maximum profit from buying and selling a stock once.
 */
public class BestTimeToBuyAndSellStock {
    /**
     * Algorithm: Track the minimum price seen so far and calculate potential profit at each step.
     */
    public int maxProfit(int[] prices) {
        // Pattern: Two Pointers / Sliding Window | Time: O(n), Space: O(1)
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price); // Track buy point
            maxProfit = Math.max(maxProfit, price - minPrice); // Track max sell profit
        }
        return maxProfit;
    }
    // FAANG Tip: This is a 1D DP problem optimized to O(1) space. Mention that we only care about the lowest price before current day.

    public static void main(String[] args) {
        var sol = new BestTimeToBuyAndSellStock();
        System.out.println(sol.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // Expected: 5
    }
}

/**
 * Dry Run:
 * Input: prices = [7, 1, 5, 3, 6, 4]
 *
 * 1. Initialization:
 *    minPrice = ∞, maxProfit = 0
 *
 * 2. Iterations:
 *    - price = 7:
 *      minPrice = min(∞, 7) = 7
 *      maxProfit = max(0, 7 - 7) = 0
 *
 *    - price = 1:
 *      minPrice = min(7, 1) = 1
 *      maxProfit = max(0, 1 - 1) = 0
 *
 *    - price = 5:
 *      minPrice = min(1, 5) = 1
 *      maxProfit = max(0, 5 - 1) = 4
 *
 *    - price = 3:
 *      minPrice = min(1, 3) = 1
 *      maxProfit = max(4, 3 - 1) = 4
 *
 *    - price = 6:
 *      minPrice = min(1, 6) = 1
 *      maxProfit = max(4, 6 - 1) = 5
 *
 *    - price = 4:
 *      minPrice = min(1, 4) = 1
 *      maxProfit = max(5, 4 - 1) = 5
 *
 * 3. Result: 5
 */
