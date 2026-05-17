package com.naresh.a_dsalgo.dp.dp1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem: Longest Increasing Subsequence
 * Description: Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */
public class LongestIncreasingSubsequence {
    /**
     * Algorithm: Patient sorting approach using binary search to maintain a tail array.
     * (Existing O(N log N) implementation)
     */
    public int lengthOfLIS(int[] nums) {
        // Pattern: Binary Search / Patience Sorting | Time: O(n log n), Space: O(n)
        if (nums == null || nums.length == 0) return 0;
        var tails = new int[nums.length];
        var size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                var m = (i + j) / 2;
                if (tails[m] < x) i = m + 1;
                else j = m;
            }
            tails[i] = x; // Update tail of LIS with length i+1
            if (i == size) size++;
        }
        return size;
    }

    /**
     * Algorithm: Dynamic Programming (O(N^2) approach)
     */
    public int lengthOfLIS_DP(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] Lis = new int[nums.length];
        Arrays.fill(Lis, 1);
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    Lis[i] = Math.max(Lis[i], 1 + Lis[j]);
                    max = Math.max(max, Lis[i]);
                }
            }
        }
        return max;
    }

    /**
     * Algorithm: Optimized Binary Search (O(N log N) approach using ArrayList)
     */
    public int lengthOfLIS_BinarySearchOptimized(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                // Find the smallest element in sub that is >= num
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        return sub.size();
    }

    /**
     * Helper method for lengthOfLIS_BinarySearchOptimized:
     * Finds the index of the smallest element in 'sub' that is greater than or equal to 'num'.
     * If 'num' is greater than all elements, returns sub.size().
     * This is a standard "lower bound" binary search.
     */
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int low = 0;
        int high = sub.size() - 1;
        int insertionPoint = sub.size(); // Default if num is greater than all elements

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevent potential overflow
            if (sub.get(mid) >= num) {
                insertionPoint = mid; // Found a potential candidate, try to find an earlier one
                high = mid - 1;
            } else {
                low = mid + 1; // num is larger, search in the right half
            }
        }
        return insertionPoint;
    }


    public static void main(String[] args) {
        var nums = new int[]{10,9,2,5,3,7,101,18};
        var solution = new LongestIncreasingSubsequence();

        // Test existing O(N log N) method
        var result1 = solution.lengthOfLIS(nums);
        System.out.println("LIS length (Existing O(N log N) tails array): " + result1);

        // Test O(N^2) DP method
        var result2 = solution.lengthOfLIS_DP(nums);
        System.out.println("LIS length (O(N^2) DP): " + result2);

        // Test O(N log N) optimized binary search method
        var result3 = solution.lengthOfLIS_BinarySearchOptimized(nums);
        System.out.println("LIS length (O(N log N) ArrayList + Binary Search): " + result3);
    }

    /*
     * Dry Run for existing lengthOfLIS:
     * Input: nums = {10,9,2,5,3,7,101,18}
     *
     * Brief trace (tails updates):
     * tails after processing 10 -> [10]
     * after 9 -> [9]
     * after 2 -> [2]
     * after 5 -> [2,5]
     * after 3 -> [2,3]
     * after 7 -> [2,3,7]
     * after 101 -> [2,3,7,101]
     * after 18 -> [2,3,7,18]
     * Result: size = 4
     */
    // FAANG Tip: While O(n^2) DP is common, FAANG interviews often expect the O(n log n) binary search optimization.
}
