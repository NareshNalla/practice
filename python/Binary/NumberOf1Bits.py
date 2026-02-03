'''
https://leetcode.com/problems/number-of-1-bits/
Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).
Ex1 Input: n = 11
Output: 3
Explanation:
The input binary string 1011 has a total of three set bits.

Input: n = 128

Output: 1  //10000000
'''
class NumberOf1Bits:
    def hammingWeight(self, n: int) -> int:
        """
        Counts the number of set bits (1s) in the binary representation of n.
        
        Complexity:
            Time: O(k) - Where k is the number of set bits. In the worst case (32-bit integer), it's O(32) i.e. O(1).
                         This is more efficient than looping through all bits if only a few are set.
            Space: O(1) - No extra space used.
        
        Pattern:
            Bit Manipulation (Brian Kernighan's Algorithm).
            - The expression n & (n - 1) always unsets the rightmost set bit.
            - By repeatedly applying this until n becomes 0, we can count exactly how many 1s are there.
        """
        # Steps to solve:
        # 1. Initialize count to 0.
        # 2. Iterate while n is greater than 0.
        # 3. Inside the loop, clear the least significant bit set to 1 using n = n & (n - 1).
        # 4. Increment count.
        # 5. Return count.
        
        count = 0
        while n:
            n &= (n - 1)
            count += 1
        return count

if __name__ == "__main__":
    solution = NumberOf1Bits()
    
    # Test Case 1
    n1 = 11
    expected1 = 3
    result1 = solution.hammingWeight(n1)
    print(f"Input: n = {n1}")
    print(f"Output: {result1}")
    assert result1 == expected1, f"Test Case 1 Failed: Expected {expected1}, got {result1}"
    print("Test Case 1 Passed!")
    print("-" * 20)

    # Test Case 2
    n2 = 128
    expected2 = 1
    result2 = solution.hammingWeight(n2)
    print(f"Input: n = {n2}")
    print(f"Output: {result2}")
    assert result2 == expected2, f"Test Case 2 Failed: Expected {expected2}, got {result2}"
    print("Test Case 2 Passed!")
    
    # Test Case 3 (Edge case: 0)
    n3 = 0
    expected3 = 0
    result3 = solution.hammingWeight(n3)
    print(f"Input: n = {n3}")
    print(f"Output: {result3}")
    assert result3 == expected3, f"Test Case 3 Failed: Expected {expected3}, got {result3}"
    print("Test Case 3 Passed!")