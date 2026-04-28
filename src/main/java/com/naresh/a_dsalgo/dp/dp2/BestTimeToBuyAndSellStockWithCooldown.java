package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Best Time to Buy and Sell Stock with Cooldown
 * Description: You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times), but you must sell the stock before you buy again.
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown period is one day).
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    /**
     * Algorithm: DP with three states: `buy`, `sell`, `cooldown`.
     * `buy[i]` = max profit ending on day `i` with a stock in hand.
     * `sell[i]` = max profit ending on day `i` with no stock in hand, and just sold.
     * `cooldown[i]` = max profit ending on day `i` with no stock in hand, and not just sold (either rested or sold on day i-2 or earlier).
     */
    public int maxProfit(int[] prices) {
        // Pattern: DP (State Machine) | Time: O(n), Space: O(1)
        if (prices == null || prices.length <= 1) return 0;

        int buy = -prices[0]; // Max profit if we buy on day 0
        int sell = 0;         // Max profit if we sell on day 0 (impossible, so 0)
        int cooldown = 0;     // Max profit if we cooldown on day 0 (impossible, so 0)

        for (int i = 1; i < prices.length; i++) {
            int prevBuy = buy;
            int prevSell = sell;
            int prevCooldown = cooldown;

            buy = Math.max(prevBuy, prevCooldown - prices[i]); // Either hold previous buy, or buy after cooldown
            sell = prevBuy + prices[i];                        // Sell today
            cooldown = Math.max(prevSell, prevCooldown);       // Either cooldown after sell, or continue cooldown
        }
        return Math.max(sell, cooldown); // Max profit is either from selling or cooling down
    }
    // FAANG Tip: This is a classic state machine DP problem. Clearly defining states and transitions is key.
}
