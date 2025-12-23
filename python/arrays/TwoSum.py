from typing import List

class TwoSum:
    """Two Sum Problem: Find two numbers that add up to target."""

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        Optimized approach using HashMap.
        Time: O(n), Space: O(n)

        Thinking: For each number x, check if (target - x) was seen before.
        If yes, we found a pair. If no, store x and continue.
        """
        prevHashMap = {}
        for i, n in enumerate(nums):
            complement = target - n
            if complement in prevHashMap:
                return [prevHashMap[complement], i]
            prevHashMap[n] = i

        # No solution found
        return []

    def twoSumBruteForce(self, nums: List[int], target: int) -> List[int]:
        """
        Brute-force approach: try every pair.
        Time: O(n^2), Space: O(1)

        Thinking: For each i, check all j > i to see if nums[i] + nums[j] == target.
        """
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

        # No solution found
        return []


# Test cases
if __name__ == "__main__":
    solution = TwoSum()

    # Test 1: Normal case
    nums1 = [2, 7, 11, 15]
    target1 = 9
    result_optimized = solution.twoSum(nums1, target1)
    result_brute = solution.twoSumBruteForce(nums1, target1)
    print(f"Test 1: nums={nums1}, target={target1}")
    print(f"  Optimized (HashMap): {result_optimized}")
    print(f"  Brute-force:         {result_brute}")

    # Test 2: Duplicate numbers
    nums2 = [3, 3]
    target2 = 6
    result_optimized2 = solution.twoSum(nums2, target2)
    result_brute2 = solution.twoSumBruteForce(nums2, target2)
    print(f"\nTest 2: nums={nums2}, target={target2}")
    print(f"  Optimized (HashMap): {result_optimized2}")
    print(f"  Brute-force:         {result_brute2}")

    # Test 3: Negative numbers
    nums3 = [-1, -2, -3, 5, 10]
    target3 = 7
    result_optimized3 = solution.twoSum(nums3, target3)
    result_brute3 = solution.twoSumBruteForce(nums3, target3)
    print(f"\nTest 3: nums={nums3}, target={target3}")
    print(f"  Optimized (HashMap): {result_optimized3}")
    print(f"  Brute-force:         {result_brute3}")

    # Test 4: No solution
    nums4 = [1, 2, 3]
    target4 = 10
    result_optimized4 = solution.twoSum(nums4, target4)
    result_brute4 = solution.twoSumBruteForce(nums4, target4)
    print(f"\nTest 4: nums={nums4}, target={target4}")
    print(f"  Optimized (HashMap): {result_optimized4}")
    print(f"  Brute-force:         {result_brute4}")
