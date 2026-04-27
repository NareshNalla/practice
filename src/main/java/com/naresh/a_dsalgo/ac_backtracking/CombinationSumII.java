package com.naresh.a_dsalgo.ac_backtracking;

import java.util.*;

/**
 * Problem: Combination Sum II
 * Description: Find all unique combinations where numbers sum to target. Each number used once; avoid duplicate results.
 */
public class CombinationSumII {
    /**
     * Algorithm: Sort candidates first. Use backtracking with deduplication logic to skip same elements at same level.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Pattern: Backtracking (Deduplication) | Time: O(2^n), Space: O(target)
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>(); //current or combinations any
        Arrays.sort(candidates); // Essential for deduplication
        backtrack(target, res, combination, 0, candidates);
        return res;
    }

    private void backtrack(int target, List<List<Integer>> res, List<Integer> combination, int start, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(combination)); // Found valid combination
        } else if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates at same level
            }
            if (candidates[i] > target) {
                break; // Optimization: further elements are too large
            }
            if(target - candidates[i] < 0){
                break; //Early termination if the remaining sum becomes negative
            }
            combination.add(candidates[i]); // Choose
            backtrack(target - candidates[i], res, combination, i + 1, candidates); // Explore (next index)
            combination.remove(combination.size() - 1); // Un-choose (Backtrack)
        }
    }
    // FAANG Tip: Sorting + `if (i > start && nums[i] == nums[i-1])` is the standard pattern for avoiding duplicate subsets.

    public static void main(String[] args) {
        var solution = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println("Combinations for 8: " + solution.combinationSum2(candidates, 8));
    }
}
