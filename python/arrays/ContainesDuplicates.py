from typing import List
class ContainesDuplicate:
    def containsDuplicate(self, nums: List[int]) -> bool:
        hashset = set()
        for n in nums:
            if n in hashset:
                return True
            hashset.add(n)
        return False
# Test cases
if __name__ == "__main__":
    solution = ContainesDuplicate()
    nums = [1,2,4,6]
    res = solution.containsDuplicate(nums)
    print(res)