'''
https://leetcode.com/problems/search-in-rotated-sorted-array/description/
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
'''
from typing import List
class SearchInRotatedSortedArray:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l<=r:
            mid = (l+r)//2
            if target == nums[mid]:
                return mid
            #left sorted portion
            if nums[l] <= nums[mid]:
                if target > nums[mid] or target < nums[l]:
                    l = mid+1
                else:
                    r = mid - 1

            #right sorted portion
            else:
                if target < nums[mid] or target > nums[r]:
                    r = mid -1
                else:
                    l = mid + 1

        return -1


if __name__ == "__main__":
    nums = [4, 5, 6, 7, 0, 1, 2]
    solution =  SearchInRotatedSortedArray()
    print(solution.search(nums, 0))

