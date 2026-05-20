package com.naresh.a_dsalgo.Intervals.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: Meeting Rooms II (LeetCode 253)
 * Description: Given an array of meeting time intervals `intervals` where `intervals[i] = [starti, endi]`,
 * return the minimum number of conference rooms required.
 */
public class MeetingRoomsII {

    /**
     * Algorithm: Greedy approach using a min-heap.
     * 1. Sort all intervals by their start times.
     * 2. Initialize a min-heap to store the end times of meetings. This heap will always give us
     *    the meeting that finishes earliest among those currently occupying rooms.
     * 3. Iterate through the sorted intervals:
     *    a. If the heap is not empty and the current meeting's start time is greater than or equal to
     *       the earliest ending meeting in the heap (`minHeap.peek()`), it means a room becomes free.
     *       Remove that meeting's end time from the heap (`minHeap.poll()`).
     *    b. Add the current meeting's end time to the heap (`minHeap.offer(interval[1])`). This meeting
     *       now occupies a room.
     * 4. The maximum size the heap reaches during the iteration is the minimum number of rooms required.
     *    The final size of the heap will be this maximum.
     *
     * @param intervals A 2D array of meeting time intervals `[start, end]`.
     * @return The minimum number of conference rooms required.
     */
    public int minMeetingRooms(int[][] intervals) {
        // Pattern: Greedy (Sorting + Min-Heap) | Time: O(N log N), Space: O(N)
        if (intervals == null || intervals.length == 0) return 0;

        // Sort intervals by their start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Min-heap to store the end times of meetings currently in progress
        var minHeap = new PriorityQueue<Integer>();
        minHeap.offer(intervals[0][1]); // Add the end time of the first meeting

        for (var i = 1; i < intervals.length; i++) {
            // If the current meeting's start time is >= the earliest ending meeting,
            // it means a room is free.
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll(); // Free up that room
            }
            minHeap.offer(intervals[i][1]); // Occupy a room with the current meeting's end time
        }
        return minHeap.size(); // The number of rooms needed is the max size of the heap
    }
    // FAANG Tip: This problem is a classic application of a min-heap to track resource allocation (meeting rooms). Sorting by start time is crucial.

    public static void main(String[] args) {
        var solution = new MeetingRoomsII();

        // Test Case 1: Example from LeetCode
        var intervals1 = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        // Expected: 2 (e.g., [0,30] in Room 1, [5,10] in Room 2, [15,20] in Room 2 after [5,10] ends)
        System.out.println("Intervals: " + Arrays.deepToString(intervals1) + " -> Min Rooms: " + solution.minMeetingRooms(intervals1));

        // Test Case 2: Example from LeetCode
        var intervals2 = new int[][]{{7, 10}, {2, 4}};
        // Expected: 1
        System.out.println("Intervals: " + Arrays.deepToString(intervals2) + " -> Min Rooms: " + solution.minMeetingRooms(intervals2));

        // Test Case 3: No overlap
        var intervals3 = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        // Expected: 1
        System.out.println("Intervals: " + Arrays.deepToString(intervals3) + " -> Min Rooms: " + solution.minMeetingRooms(intervals3));

        // Test Case 4: All overlap
        var intervals4 = new int[][]{{1, 10}, {2, 9}, {3, 8}};
        // Expected: 3
        System.out.println("Intervals: " + Arrays.deepToString(intervals4) + " -> Min Rooms: " + solution.minMeetingRooms(intervals4));

        // Test Case 5: Empty intervals
        var intervals5 = new int[][]{};
        // Expected: 0
        System.out.println("Intervals: " + Arrays.deepToString(intervals5) + " -> Min Rooms: " + solution.minMeetingRooms(intervals5));

        // Test Case 6: Single interval
        var intervals6 = new int[][]{{1, 10}};
        // Expected: 1
        System.out.println("Intervals: " + Arrays.deepToString(intervals6) + " -> Min Rooms: " + solution.minMeetingRooms(intervals6));
    }
}
