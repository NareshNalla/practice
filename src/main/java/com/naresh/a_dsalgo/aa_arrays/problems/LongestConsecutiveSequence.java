package com.naresh.a_dsalgo.aa_arrays.problems;

import java.util.*;

/**
 * Problem: Longest Consecutive Sequence
 * Description: Find the length of the longest consecutive elements sequence in an unsorted array.
 */
public class LongestConsecutiveSequence {
    /**
     * Algorithm: Use a HashSet for O(1) lookups. Only start counting from the beginning of a sequence (no n-1).
     */
    public int longestConsecutive(int[] nums) {
        // Pattern: Sequence Tracking (Set) | Time: O(n), Space: O(n)
        if (nums == null || nums.length == 0) return 0;
        var set = new HashSet<Integer>();
        for (int num : nums) set.add(num); // Build O(1) lookup set //eliminate duplicates
        var maxLen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) { // Only start of a sequence
                var currentNum = num;
                var currentLen = 1;
                while (set.contains(currentNum + 1)) { // Count chain
                    currentNum++;
                    currentLen++;
                }
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        return maxLen;
    }
    // FAANG Tip: The inner while loop only runs for the start of sequences, ensuring O(n) total time.
}
