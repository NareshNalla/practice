package com.naresh.a_dsalgo.ac_backtracking;

import java.util.*;

/**
 * Problem: Subsets II
 * Description: Given an integer array nums that may contain duplicates, return all possible subsets without duplicate results.
 */
public class SubsetsII {
    /**
     * Algorithm: Sort the array first. Use backtracking and skip adjacent duplicates at the same recursive level.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Pattern: Backtracking (Deduplication) | Time: O(n * 2^n), Space: O(n)
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(nums); // Sort to group duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums,  int start) {
        result.add(new ArrayList<>(current)); // Capture state
        for (var i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // Skip duplicates at same depth
            current.add(nums[i]); // Choose
            backtrack(result, current, nums,i + 1); // Explore
            current.remove(current.size() - 1); // Un-choose
        }
    }
    // FAANG Tip: Deduplication logic `if (i > start && nums[i] == nums[i-1])` avoids using a Set, saving space/time.

    public static void main(String[] args) {
        var solution = new SubsetsII();
        int[] nums = {1, 2, 2};
        System.out.println("Subsets with duplicates {1, 2, 2}: " + solution.subsetsWithDup(nums));
    }
}
