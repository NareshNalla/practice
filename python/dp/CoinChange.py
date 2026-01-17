'''
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Input: coins = [2], amount = 3
Output: -1

Input: coins = [1], amount = 0
Output: 0
'''
from typing import List

class CoinChange:
    """
    Time Complexity: O(amount * len(coins))
    Space Complexity: O(amount)
    """
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Initialize dp array with a value larger than amount (infinity)
        # dp[i] represents the min coins to make amount i
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        for a in range(1, amount + 1):
            for c in coins:
                if a - c >= 0:
                    dp[a] = min(dp[a], 1 + dp[a - c])

        return dp[amount] if dp[amount] != amount + 1 else -1

if __name__ == "__main__":
    solution = CoinChange()
    
    # Test Case 1
    coins1 = [1, 2, 5]
    amount1 = 11
    print(f"Coins: {coins1}, Amount: {amount1}")
    print(f"Min Coins: {solution.coinChange(coins1, amount1)}") # Expected: 3
    print("-" * 20)

    # Test Case 2
    coins2 = [2]
    amount2 = 3
    print(f"Coins: {coins2}, Amount: {amount2}")
    print(f"Min Coins: {solution.coinChange(coins2, amount2)}") # Expected: -1
    print("-" * 20)
    
    # Test Case 3
    coins3 = [1]
    amount3 = 0
    print(f"Coins: {coins3}, Amount: {amount3}")
    print(f"Min Coins: {solution.coinChange(coins3, amount3)}") # Expected: 0
