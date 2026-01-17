'''
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to
 make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
'''
from typing import List

class NonOverlappingIntervals:
    def eraseOverlapIntervalsNeet(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        #intervals.sort(key = lambda x : x[1])
        res = 0
        prevEnd = intervals[0][1]
        for start, end in intervals[1:]:
            if start >= prevEnd:
                prevEnd = end
            else:
                res += 1
            prevEnd =  min(end, prevEnd) #end

        return res

    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        # Sort by end time to maximize the number of non-overlapping intervals we can keep
        intervals.sort(key=lambda x: x[1])
        count = 0
        prev_end = intervals[0][1]
        for start, end in intervals[1:]:
            # If overlap occurs (start is less than previous end)
            if start < prev_end:
                count += 1
                # We effectively "remove" the current interval by not updating prev_end
                # because the current one ends later (or same time) and is less optimal
            else:
                # No overlap, update end time to current interval's end
                prev_end = end
        return count

if __name__ == "__main__":
    solution = NonOverlappingIntervals()
    
    # Test Case 1
    intervals1 = [[1,2],[2,3],[3,4],[1,3]]
    print(f"Input: {intervals1}")
    print(f"Output: {solution.eraseOverlapIntervalsNeet(intervals1)}") # Expected: 1
    print("-" * 20)

    # Test Case 2
    intervals2 = [[1,2],[1,2],[1,2]]
    print(f"Input: {intervals2}")
    print(f"Output: {solution.eraseOverlapIntervalsNeet(intervals2)}") # Expected: 2
    print("-" * 20)

    # Test Case 3
    intervals3 = [[1,2],[2,3]]
    print(f"Input: {intervals3}")
    print(f"Output: {solution.eraseOverlapIntervalsNeet(intervals3)}") # Expected: 0
