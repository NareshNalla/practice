'''
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith 
interval and intervals is sorted in ascending order by start i. You are also given an interval newInterval = [start, end] that represents the 
start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by start i and intervals still does not have any 
overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
'''
from typing import List

class InsertInterval:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res , i , n = [] , 0 , len(intervals)

        # 1. Add all intervals that end before the new interval starts
        while i < n and intervals[i][1] < newInterval[0]:
            res.append(intervals[i])
            i += 1

        # 2. Merge all overlapping intervals
        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i += 1
        res.append(newInterval)
        # 3. Add all remaining intervals
        while i < n:
            res.append(intervals[i])
            i += 1
            
        return res
    def insertNeet(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        for i in range(len(intervals)):
            if newInterval[1] < intervals[i] [0]:
                res.append(newInterval)
                return res + intervals[i:]
            elif newInterval[0] > intervals[i][1]:
                res.append(intervals[i])
            else:
                newInterval = [min(newInterval[0], intervals[i][0]), max(newInterval[1], intervals[i][1])]

        res.append(newInterval)
        return res

if __name__ == "__main__":
    solution = InsertInterval()
    
    # Test Case 1
    intervals1 = [[1,3],[6,9]]
    newInterval1 = [2,5]
    print(f"Input: {intervals1}, New: {newInterval1}")
    print(f"Output: {solution.insertNeet(intervals1, newInterval1)}") # Expected: [[1,5],[6,9]]
    print("-" * 20)

    # Test Case 2
    intervals2 = [[1,2],[3,5],[6,7],[8,10],[12,16]]
    newInterval2 = [4,8]
    print(f"Input: {intervals2}, New: {newInterval2}")
    print(f"Output: {solution.insert(intervals2, newInterval2)}") # Expected: [[1,2],[3,10],[12,16]]
    print("-" * 20)
    
    # Test Case 3: New interval at the beginning
    intervals3 = [[2,3],[5,7]]
    newInterval3 = [0,1]
    print(f"Input: {intervals3}, New: {newInterval3}")
    print(f"Output: {solution.insert(intervals3, newInterval3)}") # Expected: [[0,1],[2,3],[5,7]]
    print("-" * 20)

    # Test Case 4: New interval at the end
    intervals4 = [[1,2],[3,5]]
    newInterval4 = [6,8]
    print(f"Input: {intervals4}, New: {newInterval4}")
    print(f"Output: {solution.insert(intervals4, newInterval4)}") # Expected: [[1,2],[3,5],[6,8]]
