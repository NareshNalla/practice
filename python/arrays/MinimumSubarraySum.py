from typing import List
import math

class MinimumSubarraySum:
    def find_min_subarray(self, nums: List[int], k: int) -> int:
        """
        Finds the length of the smallest contiguous subarray whose sum is >= k.
        This uses a variable-size sliding window approach.

        Time Complexity: O(n) - Both left and right pointers traverse the array once.
        Space Complexity: O(1) - We only use a few variables to store state.
        """
        if not nums:
            return 0

        min_length = math.inf
        window_sum = 0
        left = 0

        # 'right' pointer expands the window
        for right in range(len(nums)):
            window_sum += nums[right]

            # Shrink the window from the left as long as the condition is met
            while window_sum >= k:
                # Update the minimum length found so far
                current_length = right - left + 1
                min_length = min(min_length, current_length)

                # Shrink the window by removing the leftmost element
                window_sum -= nums[left]
                left += 1

        # If min_length was never updated, it means no subarray met the condition
        return min_length if min_length != math.inf else 0


if __name__ == "__main__":
    solution = MinimumSubarraySum()

    # Test Case 1
    nums1 = [2, 1, 5, 2, 3, 2]
    k1 = 7
    result1 = solution.find_min_subarray(nums1, k1)
    print(f"Nums: {nums1}, k: {k1}")
    print(f"Length of smallest subarray: {result1}")  # Expected: 2 (for [5, 2])
    print("-" * 20)

    # Test Case 2
    nums2 = [2, 1, 5, 2, 8]
    k2 = 7
    result2 = solution.find_min_subarray(nums2, k2)
    print(f"Nums: {nums2}, k: {k2}")
    print(f"Length of smallest subarray: {result2}")  # Expected: 1 (for [8])
    print("-" * 20)

    # Test Case 3
    nums3 = [3, 4, 1, 1, 6]
    k3 = 8
    result3 = solution.find_min_subarray(nums3, k3)
    print(f"Nums: {nums3}, k: {k3}")
    print(f"Length of smallest subarray: {result3}")  # Expected: 3 (for [3, 4, 1] or [1, 1, 6])
    print("-" * 20)

    # Test Case 4: No solution possible
    nums4 = [1, 1, 1, 1, 1]
    k4 = 8
    result4 = solution.find_min_subarray(nums4, k4)
    print(f"Nums: {nums4}, k: {k4}")
    print(f"Length of smallest subarray: {result4}")  # Expected: 0
    print("-" * 20)
