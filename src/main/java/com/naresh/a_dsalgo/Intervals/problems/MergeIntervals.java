package com.naresh.a_dsalgo.Intervals.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Problem: Merge Intervals (LeetCode 56)
 * Description: Given an array of `intervals` where `intervals[i] = [starti, endi]`,
 * merge all overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 */
public class MergeIntervals {

    /**
     * Algorithm: Sort the intervals by their start times. Iterate through the sorted intervals,
     * merging overlapping ones. Maintain a `mergedIntervals` list. If the current interval
     * does not overlap with the last interval in `mergedIntervals`, add it. Otherwise,
     * update the end of the last interval in `mergedIntervals` to be the maximum of its
     * current end and the current interval's end.
     *
     * @param intervals A 2D array of intervals `[start, end]`.
     * @return A 2D array of merged, non-overlapping intervals.
     */
    public int[][] merge(int[][] intervals) {
        // Pattern: Interval Sorting + Merging | Time: O(N log N), Space: O(N)
        if (intervals == null || intervals.length <= 1) return intervals;

        // Sort intervals by their start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        var mergedIntervals = new ArrayList<int[]>();
        mergedIntervals.add(intervals[0]); // Add the first interval

        for (var i = 1; i < intervals.length; i++) {
            var currentInterval = intervals[i];
            var lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);

            // Check for overlap: if current interval starts before or at the end of the last merged interval
            if (currentInterval[0] <= lastMergedInterval[1]) {
                // Overlap, merge by updating the end of the last merged interval
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            } else {
                // No overlap, add the current interval as a new merged interval
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
    // FAANG Tip: Sorting by start time is the crucial first step for most interval problems. The greedy choice to merge if overlap exists is optimal.

    public static void main(String[] args) {
        var solution = new MergeIntervals();

        // Test Case 1: Example from LeetCode
        var intervals1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // Expected: [[1, 6], [8, 10], [15, 18]]
        System.out.println("Intervals: " + Arrays.deepToString(intervals1) + " -> Merged: " + Arrays.deepToString(solution.merge(intervals1)));

        // Test Case 2: Example from LeetCode
        var intervals2 = new int[][]{{1, 4}, {4, 5}};
        // Expected: [[1, 5]]
        System.out.println("Intervals: " + Arrays.deepToString(intervals2) + " -> Merged: " + Arrays.deepToString(solution.merge(intervals2)));

        // Test Case 3: All overlapping
        var intervals3 = new int[][]{{1, 4}, {0, 4}};
        // Expected: [[0, 4]]
        System.out.println("Intervals: " + Arrays.deepToString(intervals3) + " -> Merged: " + Arrays.deepToString(solution.merge(intervals3)));

        // Test Case 4: No overlapping
        var intervals4 = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        // Expected: [[1, 2], [3, 4], [5, 6]]
        System.out.println("Intervals: " + Arrays.deepToString(intervals4) + " -> Merged: " + Arrays.deepToString(solution.merge(intervals4)));

        // Test Case 5: Empty input
        var intervals5 = new int[][]{};
        // Expected: []
        System.out.println("Intervals: " + Arrays.deepToString(intervals5) + " -> Merged: " + Arrays.deepToString(solution.merge(intervals5)));

        // Test Case 6: Single interval
        var intervals6 = new int[][]{{1, 5}};
        // Expected: [[1, 5]]
        System.out.println("Intervals: " + Arrays.deepToString(intervals6) + " -> Merged: " + Arrays.deepToString(solution.merge(intervals6)));
    }
}
