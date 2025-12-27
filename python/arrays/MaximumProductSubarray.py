'''
https://leetcode.com/problems/maximum-product-subarray/description/
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
'''
from typing import List
class MaxProductSubArray:
    def findMapProductSubArray(self, nums : List[int]) -> int:
        currMax , currMin=1, 1;
        res = max(nums)
        for  n in nums:
            if n==0:
                currMax=1
                currMin=1
                continue
            temp = n * currMax
            currMax = max(temp, n * currMin, n)
            currMin = min(temp, n, n * currMin)
            res = max(res, currMax)
        return res

if __name__ == "__main__":
    solution = MaxProductSubArray()
    #2,3,-2,4
    res = solution.findMapProductSubArray([-2,0,-1 ])
    print(res)