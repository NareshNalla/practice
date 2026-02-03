'''
https://leetcode.com/problems/missing-number/
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

'''
from typing import List

class MissingNumber:
    def missingNumber(self, nums: List[int]) -> int:
        """
        Finds the missing number in the range [0, n] from the array.
        
        Complexity:
            Time: O(n) - We iterate through the array once.
            Space: O(1) - We use constant extra space for variables.
        
        Pattern:
            Bit Manipulation (XOR).
            - The property of XOR is that a ^ a = 0 and a ^ 0 = a.
            - If we XOR all numbers from 0 to n, and then XOR that result with all numbers in 'nums',
              duplicate numbers will cancel out (become 0), leaving only the missing number.
        """
        # Steps to solve:
        # 1. Initialize 'ans' with n (the size of the array), effectively including 'n' in the XOR sum 
        #    since the loop will only go up to n-1.
        # 2. Iterate through the array using index 'i' and value 'num'.
        # 3. Update 'ans' by XORing it with the index 'i' and the value 'num'.
        #    - This effectively XORs all indices (0 to n-1) and all values in nums.
        #    - Since we initialized with n, we have XORed all numbers from 0 to n against the values present in nums.
        # 4. Return 'ans', which now holds the missing number.
        
        n = len(nums)
        ans = n
        for i, num in enumerate(nums):
            ans ^= i ^ num
        return ans

if __name__ == "__main__":
    solution = MissingNumber()
    
    # Test Case 1
    nums1 = [3, 0, 1]
    expected1 = 2
    result1 = solution.missingNumber(nums1)
    print(f"Input: nums = {nums1}")
    print(f"Output: {result1}")
    assert result1 == expected1, f"Test Case 1 Failed: Expected {expected1}, got {result1}"
    print("Test Case 1 Passed!")
    print("-" * 20)

    # Test Case 2
    nums2 = [0, 1]
    expected2 = 2
    result2 = solution.missingNumber(nums2)
    print(f"Input: nums = {nums2}")
    print(f"Output: {result2}")
    assert result2 == expected2, f"Test Case 2 Failed: Expected {expected2}, got {result2}"
    print("Test Case 2 Passed!")
    
    # Test Case 3
    nums3 = [9,6,4,2,3,5,7,0,1]
    expected3 = 8
    result3 = solution.missingNumber(nums3)
    print(f"Input: nums = {nums3}")
    print(f"Output: {result3}")
    assert result3 == expected3, f"Test Case 3 Failed: Expected {expected3}, got {result3}"
    print("Test Case 3 Passed!")