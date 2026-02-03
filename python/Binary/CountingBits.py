'''
https://leetcode.com/problems/counting-bits/

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

'''
from typing import List

class CountingBits:
    def countBits(self, n: int) -> List[int]:
        """
        Generates an array where the i-th element is the number of 1's in the binary representation of i.
        
        Complexity:
            Time: O(n) - We iterate through numbers from 0 to n exactly once.
            Space: O(n) - We store the result for each number up to n.
        
        Pattern:
            Dynamic Programming / Bit Manipulation.
            relies on the relation: 
            - ans[i] = ans[i >> 1] + (i & 1)
            - i >> 1 is i // 2. The number of set bits in i is the same as i // 2, 
              plus 1 if i is odd (i & 1 is 1) or plus 0 if i is even.
        """
        # Steps to solve:
        # 1. Initialize an array 'ans' of size n + 1 with all zeros.
        # 2. Iterate from 1 to n.
        # 3. For each i, compute ans[i] using the relation: ans[i] = ans[i >> 1] + (i & 1).
        #    - (i >> 1) is a smaller number whose bit count we have already computed.
        #    - (i & 1) checks if the last bit is set.
        # 4. Return the array 'ans'.
        
        ans = [0] * (n + 1)
        for i in range(1, n + 1):
            ans[i] = ans[i >> 1] + (i & 1)
        return ans

if __name__ == "__main__":
    solution = CountingBits()
    
    # Test Case 1
    n1 = 2
    expected1 = [0, 1, 1]
    result1 = solution.countBits(n1)
    print(f"Input: n = {n1}")
    print(f"Output: {result1}")
    assert result1 == expected1, f"Test Case 1 Failed: Expected {expected1}, got {result1}"
    print("Test Case 1 Passed!")
    print("-" * 20)

    # Test Case 2
    n2 = 5
    expected2 = [0, 1, 1, 2, 1, 2]
    result2 = solution.countBits(n2)
    print(f"Input: n = {n2}")
    print(f"Output: {result2}")
    assert result2 == expected2, f"Test Case 2 Failed: Expected {expected2}, got {result2}"
    print("Test Case 2 Passed!")