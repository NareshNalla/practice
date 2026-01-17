'''
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
'''
from typing import List

class ProductOfArrayExceptSelf:
    """
    Time Complexity: O(N) - Two passes over the array.
    Space Complexity: O(1) - Excluding the output array.
    """
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [1] * n
        
        # 1. Calculate Prefix Products
        # res[i] will contain product of nums[0]...nums[i-1]
        prefix = 1
        for i in range(n):
            res[i] = prefix
            prefix *= nums[i]
            
        # 2. Calculate Suffix Products and multiply with Prefix
        # postfix will contain product of nums[i+1]...nums[n-1]
        postfix = 1
        for i in range(n - 1, -1, -1):
            res[i] *= postfix
            postfix *= nums[i]
            
        return res

if __name__ == "__main__":
    solution = ProductOfArrayExceptSelf()
    
    # Test Case 1
    nums1 = [1, 2, 3, 4]
    print(f"Input: {nums1}")
    print(f"Output: {solution.productExceptSelf(nums1)}") # Expected: [24, 12, 8, 6]
    print("-" * 20)

    # Test Case 2
    nums2 = [-1, 1, 0, -3, 3]
    print(f"Input: {nums2}")
    print(f"Output: {solution.productExceptSelf(nums2)}") # Expected: [0, 0, 9, 0, 0]
