'''
Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all meetings to their schedule without any conflicts.

Note: (0,8),(8,10) is not considered a conflict at 8

Example 1:
Input: intervals = [(0,30),(5,10),(15,20)]
Output: false
Explanation:
(0,30) and (5,10) will conflict
(0,30) and (15,20) will conflict

Example 2:
Input: intervals = [(5,8),(9,15)]
Output: true
'''
from typing import List
from Interval import Interval

class MeetingRooms:
    def canAttendMeetingsNeet(self, intervals: List[Interval]) -> bool:
        intervals.sort(key = lambda x : x.start)
        for i in range(1, len(intervals)):
            i1 = intervals[i -1]
            i2 = intervals[i]
            if i1.end > i2.start:
                return False
        return True
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        if not intervals:
            return True
            
        # Sort intervals by start time
        intervals.sort(key=lambda x: x.start)
        for i in range(1, len(intervals)):
            # If current meeting starts before previous meeting ends, there is a conflict
            if intervals[i].start < intervals[i-1].end:
                return False
                
        return True

if __name__ == "__main__":
    solution = MeetingRooms()
    
    # Test Case 1
    intervals1 = [Interval(0, 30), Interval(5, 10), Interval(15, 20)]
    print(f"Input: {intervals1}")
    print(f"Output: {solution.canAttendMeetingsNeet(intervals1)}") # Expected: False
    print("-" * 20)

    # Test Case 2
    intervals2 = [Interval(5, 8), Interval(9, 15)]
    print(f"Input: {intervals2}")
    print(f"Output: {solution.canAttendMeetingsNeet(intervals2)}") # Expected: True
    print("-" * 20)
    
    # Test Case 3 (Touching intervals - not a conflict)
    intervals3 = [Interval(0, 8), Interval(8, 10)]
    print(f"Input: {intervals3}")
    print(f"Output: {solution.canAttendMeetings(intervals3)}") # Expected: True
