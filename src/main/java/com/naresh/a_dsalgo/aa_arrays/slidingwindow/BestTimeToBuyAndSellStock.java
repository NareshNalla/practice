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
    public int maxProfit01(int[] prices) {

        int buy = 0;
        int sell = 1;
        int profit = 0;
        for (int i=1; i<prices.length; i++){
            profit = Math.max(profit, prices[sell]-prices[buy]);
            if (prices[sell] < prices[buy]){
                buy = sell;
            }
            sell++;
        }

        return profit;
    }
    // FAANG Tip: This is a 1D DP problem optimized to O(1) space. Mention that we only care about the lowest price before current day.

    public static void main(String[] args) {
        var sol = new BestTimeToBuyAndSellStock();
        System.out.println(sol.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // Expected: 5
        System.out.println(sol.maxProfit01(new int[]{7, 1, 5, 3, 6, 4})); // Expected: 5

    }
}
