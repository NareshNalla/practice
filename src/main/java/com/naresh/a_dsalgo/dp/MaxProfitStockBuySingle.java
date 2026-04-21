package com.naresh.a_dsalgo.dp;

class MaxProfitStockBuySingle {
    public static void main(String[] args) {
        int[] prices = {12, 14, 10, 10, 14, 13, 12, 15};
        System.out.println("Max Profit: " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        // Pattern: DP / Sliding Window / Greedy | Time: O(n), Space: O(1)
        if (prices == null || prices.length < 2) return 0;
        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
/*
1.
DP (Dynamic Programming): Because we use the result of previous days (the minimum price found so far) to
calculate the potential profit for the current day. It's a "state" we maintain .
2.
Sliding Window: You can think of the minPrice as the start of a window and the
current price as the end. We "slide" the end forward, and if we find a new minimum,
we "shrink" the window to that point.
3.
Greedy: At every step , we greedily update the minPrice and the maxProfit to ensure
 we have the best possible outcome at the end of the day.
 */
