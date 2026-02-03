'''
https://leetcode.com/problems/reverse-bits/description/
Reverse bits of a given 32 bits signed integer.

Input: n = 43261596
Output: 964176192
Explanation:
Integer	Binary
43261596	00000010100101000001111010011100
964176192	00111001011110000010100101000000

'''
class ReverseBits:
    def reverseBits(self, n: int) -> int:
        """
        Reverse bits of a given 32 bits signed integer.
        
        Complexity:
            Time: O(1) - The loop runs exactly 32 times, regardless of the input.
            Space: O(1) - We use constant extra space for variables.
        
        Pattern:
            Bit Manipulation (Accumulate and Shift).
            - We iterate 32 times (for 32-bit integer).
            - In each iteration, we shift the result 'ans' to the left to make room for the new bit.
            - We extract the last bit of 'n' using (n & 1) and add it to 'ans' using bitwise OR (|).
            - We shift 'n' to the right to process the next bit.
        """
        # Steps to solve:
        # 1. Initialize 'ans' to 0.
        # 2. Iterate 32 times (since we are dealing with 32-bit integers).
        # 3. Inside the loop:
        #    - Shift 'ans' to the left by 1 (ans = ans << 1).
        #    - If the current last bit of 'n' is 1 (checked by (n & 1)), add it to the last position of 'ans' (using | 1).
        #      *Combined step*: ans = (ans << 1) | (n & 1)
        #    - Shift 'n' to the right by 1 (n = n >> 1) to process the next bit.
        # 4. Return 'ans'.
        
        ans = 0
        for _ in range(32):
            ans = (ans << 1) | (n & 1)
            n >>= 1
        return ans

if __name__ == "__main__":
    solution = ReverseBits()
    
    # Test Case 1
    n1 = 43261596
    expected1 = 964176192
    result1 = solution.reverseBits(n1)
    print(f"Input: n = {n1}")
    print(f"Output: {result1}")
    assert result1 == expected1, f"Test Case 1 Failed: Expected {expected1}, got {result1}"
    print("Test Case 1 Passed!")
    print("-" * 20)
    
    # Test Case 2 (Zero)
    n2 = 0
    expected2 = 0
    result2 = solution.reverseBits(n2)
    print(f"Input: n = {n2}")
    print(f"Output: {result2}")
    assert result2 == expected2, f"Test Case 2 Failed: Expected {expected2}, got {result2}"
    print("Test Case 2 Passed!")

    # Test Case 3 (All 1s - theoretically -1 in signed 32-bit, but treated as unsigned int in Python logic usually for this problem context)
    # Python integers are arbitrary precision, but we treat it as 32-bit here.
    n3 = 0b11111111111111111111111111111111 # 4294967295
    expected_bin_str = bin(n3)[2:].zfill(32)[::-1] # Reverse the binary string
    expected3 = int(expected_bin_str, 2)
    result3 = solution.reverseBits(n3)
    print(f"Input: n = {n3} (All 1s)")
    print(f"Output: {result3}")
    assert result3 == expected3, f"Test Case 3 Failed: Expected {expected3}, got {result3}"
    print("Test Case 3 Passed!")