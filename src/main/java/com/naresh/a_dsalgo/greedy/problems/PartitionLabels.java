package com.naresh.a_dsalgo.greedy.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Partition Labels (LeetCode 763)
 * Description: Partition a string into maximum number of parts such that each letter appears in at most one part.
 * Return a list of integers representing the size of these parts.
 */
public class PartitionLabels {

    /**
     * Algorithm: Greedy approach. First, find the last occurrence of each character.
     * Then, iterate through the string, tracking the `currentPartitionEnd` (furthest last occurrence
     * of any character seen in the current segment). When the current index `i` reaches `currentPartitionEnd`,
     * a partition can be made.
     *
     * @param s The input string.
     * @return A list of integers representing the size of the partitions.
     */
    public List<Integer> partitionLabels(String s) {
        // Pattern: Greedy (Two Pointers / Last Occurrence) | Time: O(N), Space: O(1)
        if (s == null || s.isEmpty()) return new ArrayList<>();

        var lastOccurrence = new int[26]; // Stores last index of each char 'a' through 'z'
        for (var i = 0; i < s.length(); i++) lastOccurrence[s.charAt(i) - 'a'] = i; // Populate last occurrences

        var result = new ArrayList<Integer>();
        var partitionStart = 0;
        var currentPartitionEnd = 0; // Furthest reach for current partition

        for (var i = 0; i < s.length(); i++) {
            currentPartitionEnd = Math.max(currentPartitionEnd, lastOccurrence[s.charAt(i) - 'a']); // Update furthest reach
            if (i == currentPartitionEnd) { // Current index reached the furthest required end
                result.add(currentPartitionEnd - partitionStart + 1); // Add partition length
                partitionStart = i + 1; // Start next partition
            }
        }
        return result;
    }
    // FAANG Tip: Key insight is that a partition can be cut when the current index equals the maximum last occurrence of any character within that partition.

    public static void main(String[] args) {
        var solution = new PartitionLabels();

        var s1 = "ababcbacadefegdehijhklij";
        System.out.println("String: \"" + s1 + "\" -> Partitions: " + solution.partitionLabels(s1)); // Expected: [9, 7, 8]

        var s2 = "eccbbbbdec";
        System.out.println("String: \"" + s2 + "\" -> Partitions: " + solution.partitionLabels(s2)); // Expected: [10]

        var s3 = "abcdefg";
        System.out.println("String: \"" + s3 + "\" -> Partitions: " + solution.partitionLabels(s3)); // Expected: [1, 1, 1, 1, 1, 1, 1]

        var s4 = "aaaaa";
        System.out.println("String: \"" + s4 + "\" -> Partitions: " + solution.partitionLabels(s4)); // Expected: [5]

        var s5 = "";
        System.out.println("String: \"" + s5 + "\" -> Partitions: " + solution.partitionLabels(s5)); // Expected: []

        var s6 = "abacaba";
        System.out.println("String: \"" + s6 + "\" -> Partitions: " + solution.partitionLabels(s6)); // Expected: [7]
    }
}
