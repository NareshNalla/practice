'''
https://leetcode.com/problems/3sum/

Time Complexity: O(n^2)
- Sorting the array takes O(n log n).
- The main loop runs O(n) times, and for each iteration, the two-pointer search can take up to O(n) time.
- Overall: O(n^2).

Space Complexity: O(1) (excluding the output list)
- The algorithm uses only a constant amount of extra space (ignoring the space for the output).
- If output is considered, space is O(k), where k is the number of unique triplets found.
'''
from typing import List
class Q3Sum:

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        for i, a in enumerate(nums):
            if i>0 and a == nums[i-1]:
                continue
            l, r = i+1, len(nums) - 1
            while l<r:
                threesum = a+ nums[l] + nums[r]
                if threesum > 0:
                    r-=1
                elif threesum < 0:
                    l +=1
                else:
                    res.append([a, nums[l], nums[r]])
                    l += 1
                    while nums[l] == nums[l-1] and l < r:
                        l+=1
        return res

if __name__ == "__main__":
    nums = [-1,0,1,2,-1,-4]
    solution =  Q3Sum()
    print(solution.threeSum(nums))
