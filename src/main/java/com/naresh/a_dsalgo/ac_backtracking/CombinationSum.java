package com.naresh.a_dsalgo.ac_backtracking;

import java.util.*;

/**
 * Problem: Combination Sum
 * Description: Find all unique combinations in candidates where numbers sum to target. Candidates can be reused.
 */
public class CombinationSum {
    /**
     * Algorithm: Backtracking to explore combinations. Reuse current element by passing 'i' as start in recursion.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Pattern: Backtracking (Infinite Supply) | Time: O(2^target), Space: O(target)
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(target, res, combination, 0, candidates);
        return res;
    }

    private void backtrack(int target, List<List<Integer>> res, List<Integer> combination, int start, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(combination)); // Found valid combination
        } else if (target < 0) {
            return; // Target exceeded, stop exploring
        }

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]); // Choose
            backtrack(target - candidates[i], res, combination, i, candidates); // Explore (stay at index i to reuse)
            combination.remove(combination.size() - 1); // Un-choose (Backtrack)
        }
    }
    // FAANG Tip: Stay at the current index 'i' in the recursive call to allow element reuse (unlimited supply pattern).

    public static void main(String[] args) {
        var solution = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        System.out.println("Combinations for 7: " + solution.combinationSum(candidates, 7));
    }
}
