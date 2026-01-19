package com.naresh.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
print all permutations of an array
[1,2,3]
[[0, 1, 2], [0, 2, 1], [1, 0, 2], [1, 2, 0], [2, 1, 0], [2, 0, 1]]
 */
public class PermutationsArray {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(0, 1, 2);
        List<List<Integer>> response = new ArrayList<>();
        backtrack(nums, 0, response);
        System.out.println(response);
    }

    private static void backtrack(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }
        // Iterate from the current 'start' index to the end of the list.
        for (int i = start; i < nums.size(); i++) {
            // Swap the element at 'start' with the element at 'i'. This effectively places a different element at the current position.
            swap(nums, start, i);
            //Collections.swap(nums, start, i);
            // Recursively call backtrack for the next position (start + 1).
            backtrack(nums, start + 1, result);
            // Backtrack: Swap the elements back to their original positions.
            // This is crucial to explore other permutations correctly without affecting subsequent iterations.
            swap(nums, start, i);
        }
    }

    private static void swap(List<Integer> nums, int i, int j) {
        Integer temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}