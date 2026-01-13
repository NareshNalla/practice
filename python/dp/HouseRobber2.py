'''
https://leetcode.com/problems/house-robber-ii/description/
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

'''
from typing import List
class HouseRobber2:
    def rob(self, nums: List[int]) -> int:
        return max(nums[0], self.houseRobber(nums[1:]), self.houseRobber(nums[:-1]))
    def houseRobber(self, nums: List[int]) -> int:
        rob1, rob2 = 0, 0

        for n in nums:
            newRob = max( rob1+n, rob2)
            rob1 = rob2
            rob2 = newRob
        return rob2

if __name__ == "__main__":
    solution = HouseRobber2()

    # Test Case 1
    nums1 = [2,3, 2]
    print(f"Max loot for {nums1}: {solution.rob(nums1)}") # Expected: 3

    # Test Case 2
    nums2 = [1,2, 3, 1]
    print(f"Max loot for {nums2}: {solution.rob(nums2)}") # Expected: 4

    # Test Case 3
    nums3 = [ 1, 2, 3]
    print(f"Max loot for {nums3}: {solution.rob(nums3)}") # Expected: 3
