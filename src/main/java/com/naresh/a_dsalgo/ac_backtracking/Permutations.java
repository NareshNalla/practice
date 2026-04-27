package com.naresh.a_dsalgo.ac_backtracking;

import java.util.*;

/**
 * Problem: Permutations
 * Description: Given an array nums of distinct integers, return all the possible permutations.
 */
public class Permutations {
    /**
     * Algorithm: Backtracking with a 'used' boolean array to track visited elements.
     */
    public List<List<Integer>> permute(int[] nums) {
        // Pattern: Backtracking (Used Array) | Time: O(n * n!), Space: O(n)
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current)); // Found a permutation
            return;
        }
        for (int i = 0; i < nums.length; i++) {
//            if (used[i]){
//                continue; // Skip already used elements
//            }
            if (!used[i]){
                current.add(nums[i]); // Choose
                used[i] = true;
                backtrack(res, current, nums, used); // Explore
                used[i] = false; // Un-choose (Backtrack)
                current.remove(current.size() - 1);
            }
        }
    }
    // FAANG Tip: The 'used' array is intuitive for beginners. For O(1) extra space, consider the swap-based approach.

    /**
     * Algorithm: Swap-based backtracking. Swap current index with all subsequent indices.
     */
    public List<List<Integer>> permuteSwap(int[] nums) {
        // Pattern: Swap Backtracking | Time: O(n * n!), Space: O(n)
        List<List<Integer>> res = new ArrayList<>();
        backtrackSwap(0, nums, res);
        return res;
    }

    private void backtrackSwap(int start, int[] nums, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i); // Choose
            backtrackSwap(start + 1, nums, res); // Explore
            swap(nums, start, i); // Backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // FAANG Tip: Swap-based backtracking is highly efficient as it reuses the input array itself.

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println("Permute (Used Array): " + solution.permute(nums));
        System.out.println("Permute (Swap): " + solution.permuteSwap(nums));
    }
}
