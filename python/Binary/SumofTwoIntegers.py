'''
Sum of Two Integers https://leetcode.com/problems/sum-of-two-integers/description/
Given two integers a and b, return the sum of the two integers without using the operators + and -.
Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5

'''
class SumOfTwoIntegers:
    def getSum(self, a: int, b: int) -> int:
        """
        Calculates the sum of two integers without using + or - operators.
        
        Complexity:
            Time: O(1) - The loop runs at most 32 times (for 32-bit integers) because carry shifts left each time.
            Space: O(1) - Constant space used.
        
        Pattern:
            Bit Manipulation (Half Adder logic).
            - Sum without carry is achieved using XOR (^).
            - Carry is achieved using AND (&) followed by Left Shift (<< 1).
            - Since Python handles arbitrarily large integers, we use a mask (0xFFFFFFFF) to simulate 32-bit overflow behavior.
            - If the final result is negative in 32-bit representation (MSB is 1), we convert it back to Python's negative integer format.
        """
        # Steps to solve:
        # 1. Define a mask 0xFFFFFFFF to restrict operations to 32 bits.
        # 2. Iterate while there is a carry (b != 0).
        # 3. Inside the loop:
        #    - Calculate sum without carry: (a ^ b) & mask.
        #    - Calculate carry: ((a & b) << 1) & mask.
        #    - Update a to be the sum without carry, and b to be the carry.
        # 4. After the loop, check if 'a' represents a negative 32-bit number (if the 31st bit is 1).
        #    - If yes, return ~(a ^ mask) to convert it to Python's negative integer representation.
        #    - Otherwise, return a.
        
        mask = 0xFFFFFFFF
        
        while b != 0:
            a, b = (a ^ b) & mask, ((a & b) << 1) & mask
            
        # If a is negative in 32-bit signed integer sense (highest bit is 1)
        # 0x7FFFFFFF is the max positive 32-bit integer (0111...1)
        # If a > 0x7FFFFFFF, it means the sign bit (32nd bit) is set
        if a > 0x7FFFFFFF:
            return ~(a ^ mask)
        else:
            return a

if __name__ == "__main__":
    solution = SumOfTwoIntegers()
    
    # Test Case 1
    a1, b1 = 1, 2
    expected1 = 3
    result1 = solution.getSum(a1, b1)
    print(f"Input: a = {a1}, b = {b1}")
    print(f"Output: {result1}")
    assert result1 == expected1, f"Test Case 1 Failed: Expected {expected1}, got {result1}"
    print("Test Case 1 Passed!")
    print("-" * 20)

    # Test Case 2
    a2, b2 = 2, 3
    expected2 = 5
    result2 = solution.getSum(a2, b2)
    print(f"Input: a = {a2}, b = {b2}")
    print(f"Output: {result2}")
    assert result2 == expected2, f"Test Case 2 Failed: Expected {expected2}, got {result2}"
    print("Test Case 2 Passed!")
    
    # Test Case 3 (Negative numbers)
    a3, b3 = -1, 1
    expected3 = 0
    result3 = solution.getSum(a3, b3)
    print(f"Input: a = {a3}, b = {b3}")
    print(f"Output: {result3}")
    assert result3 == expected3, f"Test Case 3 Failed: Expected {expected3}, got {result3}"
    print("Test Case 3 Passed!")

    # Test Case 4 (Both negative)
    a4, b4 = -5, -7
    expected4 = -12
    result4 = solution.getSum(a4, b4)
    print(f"Input: a = {a4}, b = {b4}")
    print(f"Output: {result4}")
    assert result4 == expected4, f"Test Case 4 Failed: Expected {expected4}, got {result4}"
    print("Test Case 4 Passed!")