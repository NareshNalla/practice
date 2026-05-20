package com.naresh.a_dsalgo.Intervals.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Insert Interval (LeetCode 57)
 * Description: Given a set of non-overlapping intervals `intervals`, insert a new interval `newInterval`
 * into `intervals`. You may need to merge the new interval with existing intervals if it overlaps.
 * Assume that the `intervals` were initially sorted according to their start times.
 */
public class InsertInterval {

    /**
     * Algorithm: Iterate through the existing intervals.
     * 1. Add all intervals that come *before* `newInterval` (i.e., `interval.end < newInterval.start`).
     * 2. Merge `newInterval` with all overlapping intervals. Update `newInterval.start` to `min(newInterval.start, interval.start)`
     *    and `newInterval.end` to `max(newInterval.end, interval.end)`.
     * 3. Add the (potentially merged) `newInterval` to the result.
     * 4. Add all remaining intervals that come *after* the merged `newInterval`.
     *
     * @param intervals A 2D array of existing non-overlapping intervals, sorted by start time.
     * @param newInterval A 1D array representing the new interval to insert.
     * @return A 2D array of intervals after insertion and merging.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Pattern: Interval Merging | Time: O(N), Space: O(N)
        var result = new ArrayList<int[]>();
        var i = 0;
        var n = intervals.length;

        // 1. Add all intervals that come BEFORE newInterval
        while (i < n && intervals[i][1] < newInterval[0]) { // Current interval ends before newInterval starts
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge newInterval with all overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) { // Current interval overlaps with newInterval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]); // Update start
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]); // Update end
            i++;
        }
        result.add(newInterval); // Add the merged newInterval

        // 3. Add all remaining intervals that come AFTER the merged newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
    // FAANG Tip: This problem is a fundamental interval manipulation technique. The three-pass approach (before, merge, after) is clean and efficient.

    public static void main(String[] args) {
        var solution = new InsertInterval();

        // Test Case 1: Example from LeetCode (newInterval merges with existing)
        var intervals1 = new int[][]{{1, 3}, {6, 9}};
        var newInterval1 = new int[]{2, 5};
        // Expected: [[1, 5], [6, 9]]
        System.out.println("Intervals: " + Arrays.deepToString(intervals1) + ", New: " + Arrays.toString(newInterval1) +
                           " -> Result: " + Arrays.deepToString(solution.insert(intervals1, newInterval1)));

        // Test Case 2: Example from LeetCode (newInterval merges with multiple existing)
        var intervals2 = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        var newInterval2 = new int[]{4, 8};
        // Expected: [[1, 2], [3, 10], [12, 16]]
        System.out.println("Intervals: " + Arrays.deepToString(intervals2) + ", New: " + Arrays.toString(newInterval2) +
                           " -> Result: " + Arrays.deepToString(solution.insert(intervals2, newInterval2)));

        // Test Case 3: newInterval inserted at beginning
        var intervals3 = new int[][]{{3, 5}, {6, 9}};
        var newInterval3 = new int[]{1, 2};
        // Expected: [[1, 2], [3, 5], [6, 9]]
        System.out.println("Intervals: " + Arrays.deepToString(intervals3) + ", New: " + Arrays.toString(newInterval3) +
                           " -> Result: " + Arrays.deepToString(solution.insert(intervals3, newInterval3)));

        // Test Case 4: newInterval inserted at end
        var intervals4 = new int[][]{{1, 2}, {3, 5}};
        var newInterval4 = new int[]{6, 7};
        // Expected: [[1, 2], [3, 5], [6, 7]]
        System.out.println("Intervals: " + Arrays.deepToString(intervals4) + ", New: " + Arrays.toString(newInterval4) +
                           " -> Result: " + Arrays.deepToString(solution.insert(intervals4, newInterval4)));

        // Test Case 5: newInterval covers all existing intervals
        var intervals5 = new int[][]{{1, 5}};
        var newInterval5 = new int[]{0, 6};
        // Expected: [[0, 6]]
        System.out.println("Intervals: " + Arrays.deepToString(intervals5) + ", New: " + Arrays.toString(newInterval5) +
                           " -> Result: " + Arrays.deepToString(solution.insert(intervals5, newInterval5)));

        // Test Case 6: Empty intervals list
        var intervals6 = new int[][]{};
        var newInterval6 = new int[]{5, 7};
        // Expected: [[5, 7]]
        System.out.println("Intervals: " + Arrays.deepToString(intervals6) + ", New: " + Arrays.toString(newInterval6) +
                           " -> Result: " + Arrays.deepToString(solution.insert(intervals6, newInterval6)));
    }
}
