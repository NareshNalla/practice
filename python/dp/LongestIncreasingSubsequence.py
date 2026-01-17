'''
Given an integer array nums, return the length of the longest strictly increasing subsequence.

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Input: nums = [0,1,0,3,2,3]
Output: 4

Input: nums = [7,7,7,7,7,7,7]
Output: 1
'''
from typing import List
import bisect

class LongestIncreasingSubsequence:
    """
    Time Complexity: O(N log N) - Binary search for each element.
    Space Complexity: O(N) - To store the 'sub' array.
    """
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
            
        # 'sub' stores the smallest tail of all increasing subsequences of length i+1.
        # It is NOT necessarily the LIS itself, but its length is the answer.
        sub = []
        
        for x in nums:
            # If sub is empty or x is greater than the last element, append it
            if not sub or x > sub[-1]:
                sub.append(x)
            else:
                # Find the first element in sub that is >= x
                idx = bisect.bisect_left(sub, x)
                # Replace that element with x
                sub[idx] = x
        print(sub)
                
        return len(sub)

if __name__ == "__main__":
    solution = LongestIncreasingSubsequence()
    
    # Test Case 1
    nums1 = [10, 9, 2, 5, 3, 7, 101, 18]
    print(f"Input: {nums1}")
    print(f"LIS Length: {solution.lengthOfLIS(nums1)}") # Expected: 4
    print("-" * 20)

    # Test Case 2
    nums2 = [0, 1, 0, 3, 2, 3]
    print(f"Input: {nums2}")
    print(f"LIS Length: {solution.lengthOfLIS(nums2)}") # Expected: 4
    print("-" * 20)
    
    # Test Case 3
    nums3 = [7, 7, 7, 7]
    print(f"Input: {nums3}")
    print(f"LIS Length: {solution.lengthOfLIS(nums3)}") # Expected: 1
