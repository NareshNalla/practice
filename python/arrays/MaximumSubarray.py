'''
Given an integer array nums, find the subarray with the largest sum, and return its sum
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
'''
from typing import List
class MaximumSubarray:
    def maxSubArray(self, nums: List[int])-> int:
        maxSub = nums[0]
        curSum = 0
        for n in nums:
            if curSum < 0:
                curSum = 0
            curSum += n
            maxSub = max(maxSub, curSum)
        return maxSub


if __name__ == "__main__":
    solution = MaximumSubarray()
    print(solution.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))