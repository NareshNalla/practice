package com.naresh.old.javapractice.top20.dp;

class MaxProfitStockBuySinlge {
    public static int maxProfit(int[] prices) {
	if (prices == null && prices.length < 1)
	    return 0;

	int min = prices[0];

	int maxprofit = 0;
	for (int i = 1; i < prices.length; i++) {
	    maxprofit = Math.max(maxprofit, prices[i] - min);
	    min = Math.min(prices[i], min);

	}
	return maxprofit;

    }
    public static void main(String[] args) {
	int price[] = {12, 14, 10, 10, 14, 13, 12, 15};
	System.out.println(maxProfit(price));
    }
}