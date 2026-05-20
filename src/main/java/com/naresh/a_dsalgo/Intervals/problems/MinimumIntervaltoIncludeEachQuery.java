package com.naresh.a_dsalgo.Intervals.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: Minimum Interval to Include Each Query (LeetCode 1851)
 * Description: Given a 2D integer array `intervals` where `intervals[i] = [lefti, righti]`
 * and an integer array `queries`. For each query `queries[j]`, find the length of the shortest
 * interval `i` such that `lefti <= queries[j] <= righti`. If no such interval exists, the answer is -1.
 * Return an array containing the answers to the queries.
 */
public class MinimumIntervaltoIncludeEachQuery {

    /**
     * Algorithm: This problem is efficiently solved by combining sorting and a min-priority queue.
     * 1. **Prepare Queries:** Store queries as `[queryValue, originalIndex]` pairs and sort them by `queryValue`.
     * 2. **Sort Intervals:** Sort `intervals` by their `left` (start) times.
     * 3. **Iterate and Maintain Candidate Intervals:**
     *    - Use a min-priority queue (`minHeap`) to store candidate intervals, ordered by their `length`
     *      (`right - left + 1`). If lengths are equal, order by `right` endpoint.
     *    - Iterate through the sorted queries:
     *      a. **Add Intervals:** Add all intervals `[left, right]` to `minHeap` where `left <= currentQueryValue`.
     *      b. **Remove Intervals:** Remove intervals from `minHeap` whose `right` endpoint is less than
     *         `currentQueryValue` (they no longer cover the query).
     *      c. **Find Shortest:** If `minHeap` is not empty, the top element is the shortest interval
     *         covering `currentQueryValue`. Store its length in the result array at the query's
     *         `originalIndex`. Otherwise, store -1.
     *
     * @param intervals A 2D array of intervals `[left, right]`.
     * @param queries An array of query points.
     * @return An array of answers for each query.
     */
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Pattern: Sorting + Min-Heap | Time: O(N log N + Q log Q), Space: O(N + Q)
        var n = intervals.length;
        var q = queries.length;
        var ans = new int[q];

        // 1. Prepare queries: store original index to fill results correctly
        var sortedQueries = new int[q][2];
        for (var i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i]; // query value
            sortedQueries[i][1] = i;          // original index
        }

        // Sort queries by their value
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        // 2. Sort intervals by their start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Min-heap stores intervals [left, right] ordered by their length (right - left + 1)
        // If lengths are equal, order by right endpoint (or left, doesn't strictly matter for correctness here)
        var minHeap = new PriorityQueue<int[]>(
            (a, b) -> (a[1] - a[0]) - (b[1] - b[0])
        );

        var intervalIdx = 0; // Pointer for the sorted intervals array

        // 3. Iterate through sorted queries
        for (var i = 0; i < q; i++) {
            var currentQueryValue = sortedQueries[i][0];
            var originalQueryIndex = sortedQueries[i][1];

            // Add intervals whose left endpoint is <= currentQueryValue
            while (intervalIdx < n && intervals[intervalIdx][0] <= currentQueryValue) {
                minHeap.offer(intervals[intervalIdx]);
                intervalIdx++;
            }

            // Remove intervals whose right endpoint is < currentQueryValue
            while (!minHeap.isEmpty() && minHeap.peek()[1] < currentQueryValue) {
                minHeap.poll();
            }

            // If heap is not empty, the top element is the shortest valid interval
            if (!minHeap.isEmpty()) {
                var shortestInterval = minHeap.peek();
                ans[originalQueryIndex] = shortestInterval[1] - shortestInterval[0] + 1;
            } else {
                ans[originalQueryIndex] = -1; // No interval covers this query
            }
        }
        return ans;
    }
    // FAANG Tip: This is a common pattern for interval-query problems: sort both intervals and queries, then use a min-heap to maintain relevant intervals.

    public static void main(String[] args) {
        var solution = new MinimumIntervaltoIncludeEachQuery();

        // Test Case 1: Example from LeetCode
        var intervals1 = new int[][]{{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        var queries1 = new int[]{2, 3, 4, 5};
        // Expected: [3, 3, 1, 4]
        System.out.println("Intervals: " + Arrays.deepToString(intervals1) + ", Queries: " + Arrays.toString(queries1) +
                           " -> Min Intervals: " + Arrays.toString(solution.minInterval(intervals1, queries1)));

        // Test Case 2: Example from LeetCode
        var intervals2 = new int[][]{{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        var queries2 = new int[]{2, 19, 5, 4, 20};
        // Expected: [2, -1, 4, 4, 6]
        System.out.println("Intervals: " + Arrays.deepToString(intervals2) + ", Queries: " + Arrays.toString(queries2) +
                           " -> Min Intervals: " + Arrays.toString(solution.minInterval(intervals2, queries2)));

        // Test Case 3: No interval covers a query
        var intervals3 = new int[][]{{1, 2}, {5, 6}};
        var queries3 = new int[]{3, 4};
        // Expected: [-1, -1]
        System.out.println("Intervals: " + Arrays.deepToString(intervals3) + ", Queries: " + Arrays.toString(queries3) +
                           " -> Min Intervals: " + Arrays.toString(solution.minInterval(intervals3, queries3)));

        // Test Case 4: Single interval, multiple queries
        var intervals4 = new int[][]{{1, 10}};
        var queries4 = new int[]{0, 5, 11};
        // Expected: [-1, 10, -1]
        System.out.println("Intervals: " + Arrays.deepToString(intervals4) + ", Queries: " + Arrays.toString(queries4) +
                           " -> Min Intervals: " + Arrays.toString(solution.minInterval(intervals4, queries4)));

        // Test Case 5: Empty intervals
        var intervals5 = new int[][]{};
        var queries5 = new int[]{1, 2};
        // Expected: [-1, -1]
        System.out.println("Intervals: " + Arrays.deepToString(intervals5) + ", Queries: " + Arrays.toString(queries5) +
                           " -> Min Intervals: " + Arrays.toString(solution.minInterval(intervals5, queries5)));
    }
}
