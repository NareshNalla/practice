package com.naresh.a_dsalgo.ac_backtracking;

import java.util.*;

/**
 * Problem: Subsets (Power Set)
 * Description: Given an integer array nums of unique elements, return all possible subsets.
 */
public class Subsets {
    /**
     * Algorithm: Backtracking to explore all combinations by either including or excluding each element.
     */
    public List<List<Integer>> subsets(int[] nums) {
        // Pattern: Backtracking (Cascading) | Time: O(n * 2^n), Space: O(n)
        var result = new ArrayList<List<Integer>>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add every valid state to result
        for (var i = start; i < nums.length; i++) {
            current.add(nums[i]); // Choose
            generateSubsets(i + 1, nums, current, result); // Explore
            current.remove(current.size() - 1); // Un-choose
        }
    }
    // FAANG Tip: Every recursive call adds to the result, reflecting the 2^n nature of the power set.

    public static void main(String[] args) {
        var solution = new Subsets();
        int[] nums = {1, 2, 1};
        System.out.println("Subsets of {1, 2, 3}: " + solution.subsets(nums));
    }
}
