'''
find the max sum subarray of a fixed size k
[4, 2, 1, 7, 8, 1, 2, 8, 1, 0] k =3
res 16
'''
from typing import List

class MaxSumInKSize:
    def findMaxSumInKSize(self, nums: List[int], k: int) -> int:
        """
        Find the maximum sum of a subarray of fixed size k using sliding window.
        Time: O(n), Space: O(1)
        """
        if not nums or k > len(nums):
            return 0

        # Calculate sum of first window of size k
        window_sum = sum(nums[:k])
        max_sum = window_sum

        # Slide the window across the array
        for i in range(k, len(nums)):
            # Remove leftmost element of previous window, add new rightmost element
            window_sum = window_sum - nums[i - k] + nums[i]
            max_sum = max(max_sum, window_sum)

        return max_sum

    def findMaxSumInKSizeBruteForce(self, nums: List[int], k: int) -> int:
        """
        Brute force approach: check all subarrays of size k.
        Time: O(n*k), Space: O(1)
        """
        if not nums or k > len(nums):
            return 0

        max_sum = float('-inf')

        # Try every subarray of size k
        for i in range(len(nums) - k + 1):
            current_sum = sum(nums[i:i + k])
            max_sum = max(max_sum, current_sum)

        return max_sum


# Test cases
if __name__ == "__main__":
    solution = MaxSumInKSize()

    # Test 1: Example from problem
    nums1 = [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
    k1 = 3
    result_optimized = solution.findMaxSumInKSize(nums1, k1)
    result_brute = solution.findMaxSumInKSizeBruteForce(nums1, k1)
    print(f"Test 1: nums={nums1}, k={k1}")
    print(f"  Optimized (Sliding Window): {result_optimized}")
    print(f"  Brute-force:                {result_brute}")
    print(f"  Expected: 16")
    print()

    # Test 2: Simple case
    nums2 = [1, 4, 2, 10, 2, 3, 1, 0, 20]
    k2 = 4
    result_optimized2 = solution.findMaxSumInKSize(nums2, k2)
    result_brute2 = solution.findMaxSumInKSizeBruteForce(nums2, k2)
    print(f"Test 2: nums={nums2}, k={k2}")
    print(f"  Optimized (Sliding Window): {result_optimized2}")
    print(f"  Brute-force:                {result_brute2}")
    print()

    # Test 3: All negative numbers
    nums3 = [-1, -2, -3, -4, -5]
    k3 = 2
    result_optimized3 = solution.findMaxSumInKSize(nums3, k3)
    result_brute3 = solution.findMaxSumInKSizeBruteForce(nums3, k3)
    print(f"Test 3: nums={nums3}, k={k3}")
    print(f"  Optimized (Sliding Window): {result_optimized3}")
    print(f"  Brute-force:                {result_brute3}")
    print()

    # Test 4: Single window
    nums4 = [5, 10, 15]
    k4 = 3
    result_optimized4 = solution.findMaxSumInKSize(nums4, k4)
    result_brute4 = solution.findMaxSumInKSizeBruteForce(nums4, k4)
    print(f"Test 4: nums={nums4}, k={k4}")
    print(f"  Optimized (Sliding Window): {result_optimized4}")
    print(f"  Brute-force:                {result_brute4}")
