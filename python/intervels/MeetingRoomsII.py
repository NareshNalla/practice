'''
Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all meetings without any conflicts.

Note: (0,8),(8,10) is not considered a conflict at 8.

Example 1:
Input: intervals = [(0,40),(5,10),(15,20)]
Output: 2
Explanation:
day1: (0,40)
day2: (5,10),(15,20)

Example 2:
Input: intervals = [(4,9)]
Output: 1
'''
from typing import List

from Interval import Interval

class MeetingRoomsII:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        if not intervals:
            return 0
            
        # Separate and sort start and end times
        starts = sorted([i.start for i in intervals])
        ends = sorted([i.end for i in intervals])
        
        res, count = 0, 0
        s, e = 0, 0
        
        # Iterate through all start times
        while s < len(intervals):
            # If a meeting starts before the earliest ending meeting finishes, we need a new room
            if starts[s] < ends[e]:
                count += 1
                s += 1
            # A meeting ended, free up a room
            else:
                count -= 1
                e += 1
            res = max(res, count)
            
        return res

if __name__ == "__main__":
    solution = MeetingRoomsII()
    
    # Test Case 1
    intervals1 = [Interval(0, 40), Interval(5, 10), Interval(15, 20)]
    print(f"Input: {intervals1}")
    print(f"Output: {solution.minMeetingRooms(intervals1)}") # Expected: 2
    print("-" * 20)

    # Test Case 2
    intervals2 = [Interval(4, 9)]
    print(f"Input: {intervals2}")
    print(f"Output: {solution.minMeetingRooms(intervals2)}") # Expected: 1
    print("-" * 20)
    
    # Test Case 3 (Touching intervals)
    intervals3 = [Interval(0, 8), Interval(8, 10)]
    print(f"Input: {intervals3}")
    print(f"Output: {solution.minMeetingRooms(intervals3)}") # Expected: 1
