package com.naresh.a_dsalgo.Intervals.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: Non-overlapping Intervals (LeetCode 435)
 * Description: Given an array of intervals `intervals` where `intervals[i] = [starti, endi]`,
 * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */
public class NonOverlappingIntervals {

    /**
     * Algorithm: Greedy approach. Sort intervals by their end times. Iterate through the sorted intervals,
     * keeping track of the end time of the last non-overlapping interval found (`prevEnd`). If a current
     * interval overlaps with `prevEnd`, it must be removed (increment `removedCount`). Otherwise, update `prevEnd`.
     *
     * @param intervals A 2D array of intervals `[start, end]`.
     * @return The minimum number of intervals to remove.
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // Pattern: Greedy (Sorting) | Time: O(N log N), Space: O(1)
        if (intervals == null || intervals.length <= 1) return 0;

        // Sort intervals by their end times. This is the greedy choice:
        // By picking the interval that finishes earliest, we leave maximum room for subsequent intervals.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        var removedCount = 0;
        var prevEnd = intervals[0][1]; // End time of the first non-overlapping interval chosen

        // Iterate from the second interval
        for (var i = 1; i < intervals.length; i++) {
            var currentStart = intervals[i][0];
            var currentEnd = intervals[i][1];

            if (currentStart < prevEnd) { // Overlap detected
                removedCount++; // This interval must be removed
            } else { // No overlap
                prevEnd = currentEnd; // Update prevEnd to current interval's end
            }
        }
        return removedCount;
    }
    // FAANG Tip: The greedy strategy of sorting by end time is optimal. It maximizes the remaining available space for subsequent intervals.

    public static void main(String[] args) {
        var solution = new NonOverlappingIntervals();

        // Test Case 1: Example from LeetCode
        var intervals1 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        // Expected: 1 (Remove [1,3])
        System.out.println("Intervals: " + Arrays.deepToString(intervals1) + " -> Removed: " + solution.eraseOverlapIntervals(intervals1));

        // Test Case 2: Example from LeetCode
        var intervals2 = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        // Expected: 2 (Keep one [1,2], remove two [1,2])
        System.out.println("Intervals: " + Arrays.deepToString(intervals2) + " -> Removed: " + solution.eraseOverlapIntervals(intervals2));

        // Test Case 3: Example from LeetCode
        var intervals3 = new int[][]{{1, 2}, {2, 3}};
        // Expected: 0 (No overlaps)
        System.out.println("Intervals: " + Arrays.deepToString(intervals3) + " -> Removed: " + solution.eraseOverlapIntervals(intervals3));

        // Test Case 4: Complex overlaps
        var intervals4 = new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        // Expected: 2 (Keep [1,100], remove [1,11], [2,12] OR keep [11,22], remove [1,100], [1,11], [2,12] -> 3 removed.
        // Sorted by end: [1,11], [2,12], [11,22], [1,100]
        // Keep [1,11], prevEnd=11. [2,12] overlaps, remove. [11,22] no overlap, prevEnd=22. [1,100] overlaps, remove. Total 2 removed.
        System.out.println("Intervals: " + Arrays.deepToString(intervals4) + " -> Removed: " + solution.eraseOverlapIntervals(intervals4));

        // Test Case 5: Empty intervals
        var intervals5 = new int[][]{};
        // Expected: 0
        System.out.println("Intervals: " + Arrays.deepToString(intervals5) + " -> Removed: " + solution.eraseOverlapIntervals(intervals5));

        // Test Case 6: Single interval
        var intervals6 = new int[][]{{1, 5}};
        // Expected: 0
        System.out.println("Intervals: " + Arrays.deepToString(intervals6) + " -> Removed: " + solution.eraseOverlapIntervals(intervals6));
    }
}
