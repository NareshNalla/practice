package com.naresh.a_dsalgo.greedy.problems;

import java.util.Arrays;

/**
 * Problem: Merge Triplets to Form Target Triplet (LeetCode 1899)
 * Description: Determine if a target triplet `[x, y, z]` can be formed by merging (taking max of components)
 * a subset of given `triplets`, where `triplets[i] = [ai, bi, ci]`.
 */
public class MergeTripletsToFormTargetTriplet {

    /**
     * Algorithm: Greedy approach. Iterate through triplets, only considering those where all components
     * are less than or equal to the target's corresponding components. For valid triplets, update a
     * `merged` triplet by taking the maximum of its current components and the triplet's components.
     * Finally, check if the `merged` triplet matches the `target`.
     *
     * @param triplets A 2D array of integer triplets.
     * @param target An integer array representing the target triplet.
     * @return True if the target triplet can be formed, false otherwise.
     */
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // Pattern: Greedy (Single Pass) | Time: O(N), Space: O(1)
        var merged = new int[]{0, 0, 0}; // Stores max values achieved from valid triplets

        for (var triplet : triplets) {
            // Only consider triplets that do not exceed the target in any dimension
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                merged[0] = Math.max(merged[0], triplet[0]); // Update first component
                merged[1] = Math.max(merged[1], triplet[1]); // Update second component
                merged[2] = Math.max(merged[2], triplet[2]); // Update third component
            }
        }
        // Check if the merged triplet matches the target
        return merged[0] == target[0] && merged[1] == target[1] && merged[2] == target[2];
    }
    // FAANG Tip: The greedy choice is to discard any triplet that "overshoots" the target, as it can never contribute positively.

    public static void main(String[] args) {
        var solution = new MergeTripletsToFormTargetTriplet();

        var triplets1 = new int[][]{{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        var target1 = new int[]{2, 7, 5};
        System.out.println("Triplets: " + Arrays.deepToString(triplets1) + ", Target: " + Arrays.toString(target1) +
                           " -> Can form target: " + solution.mergeTriplets(triplets1, target1)); // Expected: true

        var triplets2 = new int[][]{{3, 4, 5}, {1, 2, 3}};
        var target2 = new int[]{3, 2, 5};
        System.out.println("Triplets: " + Arrays.deepToString(triplets2) + ", Target: " + Arrays.toString(target2) +
                           " -> Can form target: " + solution.mergeTriplets(triplets2, target2)); // Expected: false

        var triplets3 = new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        var target3 = new int[]{3, 3, 3};
        System.out.println("Triplets: " + Arrays.deepToString(triplets3) + ", Target: " + Arrays.toString(target3) +
                           " -> Can form target: " + solution.mergeTriplets(triplets3, target3)); // Expected: true

        var triplets4 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        var target4 = new int[]{4, 5, 7};
        System.out.println("Triplets: " + Arrays.deepToString(triplets4) + ", Target: " + Arrays.toString(target4) +
                           " -> Can form target: " + solution.mergeTriplets(triplets4, target4)); // Expected: false

        var triplets5 = new int[][]{{10, 1, 1}, {1, 10, 1}, {1, 1, 10}};
        var target5 = new int[]{5, 5, 5};
        System.out.println("Triplets: " + Arrays.deepToString(triplets5) + ", Target: " + Arrays.toString(target5) +
                           " -> Can form target: " + solution.mergeTriplets(triplets5, target5)); // Expected: false

        var triplets6 = new int[][]{{0, 0, 0}, {1, 1, 1}};
        var target6 = new int[]{0, 0, 0};
        System.out.println("Triplets: " + Arrays.deepToString(triplets6) + ", Target: " + Arrays.toString(target6) +
                           " -> Can form target: " + solution.mergeTriplets(triplets6, target6)); // Expected: true
    }
}
