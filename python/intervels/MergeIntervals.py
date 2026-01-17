'''
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Example 3:
Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
'''
from typing import List

class MergeIntervals:
    def mergeNeet(self, intervals: List[List[int]]) -> List[List[int]]:
       intervals.sort(key = lambda i : i[0])
       output = [intervals[0]]
       for start, end in intervals[1:]:
           lastEnd = output[-1][1]
           if start <= lastEnd:
               output[-1][1] = max(lastEnd, end)
           else:
               output.append([start, end])
       return output


    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []
        # Sort by start time to ensure we can merge in a single pass
        intervals.sort(key=lambda x: x[0])
        merged = [intervals[0]]
        for current in intervals[1:]:
            last_end = merged[-1][1]
            # If overlap exists (current start <= last merged end)
            if current[0] <= last_end:
                # Merge by updating the end time to the max of both
                merged[-1][1] = max(last_end, current[1])
            else:
                # No overlap, add current interval to result
                merged.append(current)
        return merged

if __name__ == "__main__":
    solution = MergeIntervals()

    # Test Case 1
    intervals1 = [[1,3],[2,6],[8,10],[15,18]]
    print(f"Input: {intervals1}")
    print(f"Output: {solution.mergeNeet(intervals1)}") # Expected: [[1,6],[8,10],[15,18]]
    print("-" * 20)

    # Test Case 2
    intervals2 = [[1,4],[4,5]]
    print(f"Input: {intervals2}")
    print(f"Output: {solution.merge(intervals2)}") # Expected: [[1,5]]
    print("-" * 20)

    # Test Case 3 (Unsorted input)
    intervals3 = [[4,7],[1,4]]
    print(f"Input: {intervals3}")
    print(f"Output: {solution.merge(intervals3)}") # Expected: [[1,7]]
