package com.naresh.a_dsalgo.greedy.problems;

import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * Problem: File Merging (Huffman Coding variant)
 * Description: Given N files, each with a certain size, merge them into a single file.
 * The cost of merging two files is the sum of their sizes. Find the minimum cost to merge all files.
 */
public class FileMerging {

    /**
     * Algorithm: Greedy approach using a min-priority queue. Always merge the two smallest files.
     * This ensures that smaller files (which will be merged more frequently) contribute less
     * to the overall cost in later stages, leading to the minimum total cost.
     *
     * @param files An array of integers representing the sizes of the files.
     * @return The minimum total cost to merge all files.
     */
    public static int getMergeCost(int[] files) {
        // Pattern: Greedy (Priority Queue) | Time: O(N log N), Space: O(N)
        var pq = new PriorityQueue<Integer>();
        for (var file : files) pq.add(file); // Add all file sizes to PQ

        var totalCost = 0;
        while (pq.size() > 1) { // Continue merging until only one file remains
            var small1 = pq.remove(); // Get smallest file
            var small2 = pq.remove(); // Get second smallest file
            var currentMergeCost = small1 + small2;
            totalCost += currentMergeCost; // Accumulate cost
            pq.add(currentMergeCost); // Add merged file back to PQ
        }
        return totalCost;
    }
    // FAANG Tip: This problem is a direct application of Huffman Coding logic. The greedy choice of merging the two smallest elements is optimal.

    public static void main(String[] args) {
        var files1 = new int[]{2, 5, 6, 3, 8, 4};
        System.out.println("Files: " + Arrays.toString(files1) + " -> Minimum Merge Cost: " + getMergeCost(files1)); // Expected: 48

        var files2 = new int[]{6, 5, 4, 3, 1};
        System.out.println("Files: " + Arrays.toString(files2) + " -> Minimum Merge Cost: " + getMergeCost(files2)); // Expected: 31

        var files3 = new int[]{10, 20};
        System.out.println("Files: " + Arrays.toString(files3) + " -> Minimum Merge Cost: " + getMergeCost(files3)); // Expected: 30

        var files4 = new int[]{100};
        System.out.println("Files: " + Arrays.toString(files4) + " -> Minimum Merge Cost: " + getMergeCost(files4)); // Expected: 0

        var files5 = new int[]{};
        System.out.println("Files: " + Arrays.toString(files5) + " -> Minimum Merge Cost: " + getMergeCost(files5)); // Expected: 0
    }
}
