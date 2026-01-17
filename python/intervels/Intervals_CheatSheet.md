# Intervals Cheat Sheet

## 1. Insert Interval
**Goal:** Insert new interval into sorted non-overlapping list and merge if needed.
**Steps:**
1.  **Left:** Add all intervals ending before `newInterval` starts.
2.  **Merge:** While intervals overlap (`start <= newEnd`), update `newInterval` (`min(start)`, `max(end)`).
3.  **Right:** Add remaining intervals.
**Key:** 3-phase linear scan. O(N).

## 2. Merge Intervals
**Goal:** Merge all overlapping intervals.
**Steps:**
1.  **Sort:** Sort by `start` time.
2.  **Iterate:**
    *   If `current.start <= last_merged.end`: Merge (`last_merged.end = max(last_merged.end, current.end)`).
    *   Else: Add `current` to result.
**Key:** Sort first, then linear merge. O(N log N).

## 3. Non-overlapping Intervals
**Goal:** Min removals to make rest non-overlapping.
**Steps:**
1.  **Sort:** Sort by **END** time (greedy choice: keep interval that finishes earliest).
2.  **Iterate:**
    *   If `current.start < prev_end`: Overlap! Increment count (remove current).
    *   Else: No overlap. Update `prev_end = current.end`.
**Key:** Greedy sort by END time. O(N log N).

## 4. Meeting Rooms (Can Attend All?)
**Goal:** Check if any intervals overlap.
**Steps:**
1.  **Sort:** Sort by `start` time.
2.  **Check:** If `current.start < prev.end`, return `False`.
**Key:** Simple overlap check after sort. O(N log N).

## 5. Meeting Rooms II (Min Rooms)
**Goal:** Min rooms required (max concurrent meetings).
**Steps:**
1.  **Separate & Sort:** Create two sorted arrays: `starts` and `ends`.
2.  **Two Pointers:** Iterate `starts` with pointer `s`, `ends` with `e`.
    *   If `starts[s] < ends[e]`: Meeting starts before one ends -> `count++`, `s++`.
    *   Else: Meeting ended -> `count--`, `e++`.
    *   Track `max(count)`.
**Key:** Chronological sweep of start/end events. O(N log N).
