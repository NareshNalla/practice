package com.naresh.a_dsalgo.Intervals.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: Meeting Rooms (LeetCode 252)
 * Description: Given an array of meeting time intervals `intervals` where `intervals[i] = [starti, endi]`,
 * determine if a person could attend all meetings.
 */
public class MeetingRooms {

    /**
     * Algorithm: Sort the intervals by their start times. Then, iterate through the sorted intervals
     * and check if any current meeting's start time is before the previous meeting's end time.
     * If such an overlap is found, it's impossible to attend all meetings.
     *
     * @param intervals A 2D array of meeting time intervals `[start, end]`.
     * @return True if a person could attend all meetings, false otherwise.
     */
    public boolean canAttendMeetings(int[][] intervals) {
        // Pattern: Interval Sorting | Time: O(N log N), Space: O(1) (or O(N) for sort depending on implementation)
        if (intervals == null || intervals.length <= 1) return true; // No conflicts with 0 or 1 meeting

        // Sort intervals by their start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Check for overlaps
        for (var i = 1; i < intervals.length; i++) {
            // If the current meeting starts before the previous meeting ends, there's an overlap
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
    // FAANG Tip: Sorting by start time is a common first step for many interval problems. This problem is a simpler variant of Meeting Rooms II.

    public static void main(String[] args) {
        var solution = new MeetingRooms();

        // Test Case 1: Example - No overlap
        var intervals1 = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        // Expected: false (0-30 overlaps with 5-10 and 15-20)
        System.out.println("Intervals: " + Arrays.deepToString(intervals1) + " -> Can attend all: " + solution.canAttendMeetings(intervals1));

        // Test Case 2: Example - No overlap
        var intervals2 = new int[][]{{7, 10}, {2, 4}};
        // Expected: true
        System.out.println("Intervals: " + Arrays.deepToString(intervals2) + " -> Can attend all: " + solution.canAttendMeetings(intervals2));

        // Test Case 3: Edge case - Empty intervals
        var intervals3 = new int[][]{};
        // Expected: true
        System.out.println("Intervals: " + Arrays.deepToString(intervals3) + " -> Can attend all: " + solution.canAttendMeetings(intervals3));

        // Test Case 4: Edge case - Single interval
        var intervals4 = new int[][]{{1, 5}};
        // Expected: true
        System.out.println("Intervals: " + Arrays.deepToString(intervals4) + " -> Can attend all: " + solution.canAttendMeetings(intervals4));

        // Test Case 5: Overlap at boundary
        var intervals5 = new int[][]{{1, 5}, {5, 10}};
        // Expected: true (meeting ends at 5, next starts at 5, no strict overlap)
        System.out.println("Intervals: " + Arrays.deepToString(intervals5) + " -> Can attend all: " + solution.canAttendMeetings(intervals5));

        // Test Case 6: Multiple overlaps
        var intervals6 = new int[][]{{1, 4}, {2, 5}, {3, 6}};
        // Expected: false
        System.out.println("Intervals: " + Arrays.deepToString(intervals6) + " -> Can attend all: " + solution.canAttendMeetings(intervals6));
    }
}
