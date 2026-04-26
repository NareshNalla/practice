package com.naresh.a_dsalgo.aarrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 3Sum
 * Description: Find all unique triplets in the array which gives the sum of zero.
 */
public class Three3Sum {
    /**
     * Algorithm: Sort the array first. Iterate with a fixed element 'i', and use two pointers (low, high) 
     * to find pairs that sum to -nums[i]. Skip duplicates for i, low, and high.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // Pattern: Two Pointers | Time: O(n^2), Space: O(1) (excluding output)
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums); // Sort to enable two-pointer logic
        var result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate 'i'
            var low = i + 1; var high = nums.length - 1;
            while (low < high) {
                var sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++; // Skip duplicate low
                    while (low < high && nums[high] == nums[high - 1]) high--; // Skip duplicate high
                    low++; high--;
                } else if (sum < 0) low++; // Sum too small, move right
                else high--; // Sum too large, move left
            }
        }
        return result;
    }
    // FAANG Tip: Sorting is the bottleneck (O(n log n)), but two-pointer search makes overall time O(n^2). Emphasize duplicate skipping to avoid O(n^3) or extra space for sets.

    public static void main(String[] args) {
        var sol = new Three3Sum();
        var nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("Test Result: " + sol.threeSum(nums)); // Expected: [[-1, -1, 2], [-1, 0, 1]]
    }
}
