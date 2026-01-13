'''
Combination Sum - Backtracking dp
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
'''
from typing import List

class CombinationSum:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        
        def dfs(i, curr, total):
            if total == target:
                res.append(curr.copy())
                return
            if i >= len(candidates) or total > target:
                return

            # Decision 1: Include candidates[i]
            curr.append(candidates[i])
            dfs(i, curr, total + candidates[i])
            
            # Backtrack
            curr.pop()
            
            # Decision 2: Skip candidates[i] and move to next candidate
            dfs(i + 1, curr, total)

        dfs(0, [], 0)
        return res

if __name__ == "__main__":
    solution = CombinationSum()
    
    # Test Case 1
    candidates1 = [2, 3, 6, 7]
    target1 = 7
    print(f"Combinations for {candidates1} with target {target1}: {solution.combinationSum(candidates1, target1)}") 
    # Expected: [[2, 2, 3], [7]]

    # Test Case 2
    candidates2 = [2, 3, 5]
    target2 = 8
    print(f"Combinations for {candidates2} with target {target2}: {solution.combinationSum(candidates2, target2)}") 
    # Expected: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    
    # Test Case 3
    candidates3 = [2]
    target3 = 1
    print(f"Combinations for {candidates3} with target {target3}: {solution.combinationSum(candidates3, target3)}") 
    # Expected: []
