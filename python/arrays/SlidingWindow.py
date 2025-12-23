from typing import List

class SlidingWindow:
    """Buy and Sell Stock Problem: Find maximum profit with one transaction."""

    def maxProfit(self, prices: List[int]) -> int:
        """
        Sliding window approach with two pointers.
        Time: O(n), Space: O(1)

        Thinking: Use left pointer for buy price, right pointer for sell price.
        Move right forward and track max profit. When we find a lower price,
        move left to that position (new potential buy point).
        """
        if not prices or len(prices) < 2:
            return 0

        l, r = 0, 1
        maxP = 0

        while r < len(prices):
            if prices[l] < prices[r]:  # FIX: was prices[1], should be prices[l]
                profit = prices[r] - prices[l]
                maxP = max(maxP, profit)
            else:
                l = r  # FIX: move l to r when we find a lower price
            r += 1

        return maxP

    def maxProfitBruteForce(self, prices: List[int]) -> int:
        """
        Brute-force approach: try every pair.
        Time: O(n^2), Space: O(1)

        Thinking: For each i (buy), check all j > i (sell) and find max profit.
        """
        maxP = 0
        for i in range(len(prices)):
            for j in range(i + 1, len(prices)):
                profit = prices[j] - prices[i]
                maxP = max(maxP, profit)

        return maxP


# Test cases
if __name__ == "__main__":
    solution = SlidingWindow()

    # Test 1: Normal case with profit opportunity
    prices1 = [7, 1, 5, 3, 6, 4]
    result_sw1 = solution.maxProfit(prices1)
    result_brute1 = solution.maxProfitBruteForce(prices1)
    print(f"Test 1: prices={prices1}")
    print(f"  Sliding Window: {result_sw1} (buy at 1, sell at 6, profit = 5)")
    print(f"  Brute-force:    {result_brute1}")

    # Test 2: Decreasing prices (no profit)
    prices2 = [7, 6, 4, 3, 1]
    result_sw2 = solution.maxProfit(prices2)
    result_brute2 = solution.maxProfitBruteForce(prices2)
    print(f"\nTest 2: prices={prices2}")
    print(f"  Sliding Window: {result_sw2} (no profit possible)")
    print(f"  Brute-force:    {result_brute2}")

    # Test 3: Single peak
    prices3 = [2, 4, 1, 7, 5, 11]
    result_sw3 = solution.maxProfit(prices3)
    result_brute3 = solution.maxProfitBruteForce(prices3)
    print(f"\nTest 3: prices={prices3}")
    print(f"  Sliding Window: {result_sw3} (buy at 1, sell at 11, profit = 10)")
    print(f"  Brute-force:    {result_brute3}")

    # Test 4: Empty or single element
    prices4 = [5]
    result_sw4 = solution.maxProfit(prices4)
    result_brute4 = solution.maxProfitBruteForce(prices4)
    print(f"\nTest 4: prices={prices4}")
    print(f"  Sliding Window: {result_sw4}")
    print(f"  Brute-force:    {result_brute4}")

    # Test 5: All same prices
    prices5 = [5, 5, 5, 5]
    result_sw5 = solution.maxProfit(prices5)
    result_brute5 = solution.maxProfitBruteForce(prices5)
    print(f"\nTest 5: prices={prices5}")
    print(f"  Sliding Window: {result_sw5}")
    print(f"  Brute-force:    {result_brute5}")
