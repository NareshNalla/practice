'''
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
'''
from typing import List

class HouseRobber:
    def rob(self, nums: List[int]) -> int:
        rob1, rob2 = 0, 0

        # [ rob1, rob2, n, n+1, ...]
        for n in nums:
            # Calculate the max loot if we rob the current house 'n'
            # We can either:
            # 1. Rob current house 'n' + loot from 'rob1' (house before previous)
            # 2. Skip current house and keep loot from 'rob2' (previous house)
            temp = max(n + rob1, rob2)
            rob1 = rob2
            rob2 = temp
            
        return rob2

if __name__ == "__main__":
    solution = HouseRobber()
    
    # Test Case 1
    nums1 = [1, 2, 3, 1]
    print(f"Max loot for {nums1}: {solution.rob(nums1)}") # Expected: 4

    # Test Case 2
    nums2 = [2, 7, 9, 3, 1]
    print(f"Max loot for {nums2}: {solution.rob(nums2)}") # Expected: 12
    
    # Test Case 3
    nums3 = [2, 1, 1, 2]
    print(f"Max loot for {nums3}: {solution.rob(nums3)}") # Expected: 4
