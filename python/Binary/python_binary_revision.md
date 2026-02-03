# Python Binary Problems Revision Notes

This document provides a quick revision guide for common binary manipulation problems, including the techniques and high-level steps to solve them.

---

### 1. Counting Bits

- **Problem**: Given an integer `n`, return an array where each index `i` contains the number of 1's in the binary representation of `i`.
- **Technique**: Dynamic Programming
- **Steps**:
    1. Create a results array `dp` of size `n + 1`, initialized to all zeros.
    2. Iterate from `1` to `n`.
    3. For each number `i`, the number of 1's is the same as the number of 1's in `i / 2` (right shift `i >> 1`), plus `1` if `i` is odd.
    4. The formula is `dp[i] = dp[i >> 1] + (i % 2)`.
    5. Return the `dp` array.

---

### 2. Missing Number

- **Problem**: Given an array of `n` distinct numbers from `0` to `n`, find the one that is missing.
- **Technique**: Bit Manipulation (XOR) or Gauss's Formula
- **Steps (XOR Method)**:
    1. Initialize a variable `missing` to `n`.
    2. Iterate through the array with both the index `i` and the value `num`.
    3. In each iteration, XOR `missing` with `i` and `num`.
    4. Since every number from `0` to `n` will appear twice (once as an index, once as a value) except for the missing number, the final result in `missing` will be the number that's missing.
- **Steps (Gauss's Formula)**:
    1. Calculate the expected sum of numbers from `0` to `n` using the formula `n * (n + 1) / 2`.
    2. Calculate the actual sum of the numbers in the input array.
    3. The difference between the expected sum and the actual sum is the missing number.

---

### 3. Number of 1 Bits (Hamming Weight)

- **Problem**: Count the number of '1's in the binary representation of an integer.
- **Technique**: Bit Manipulation
- **Steps**:
    1. Initialize a counter to `0`.
    2. While the number `n` is not zero:
        - Use the bitwise AND operation `n & (n - 1)`. This operation unsets the rightmost '1' bit.
        - Increment the counter.
    3. Return the counter.
- **Alternative Steps**:
    1. Initialize a counter to `0`.
    2. While `n` is not zero:
        - If the last bit is a `1` (`n & 1 == 1`), increment the counter.
        - Right-shift `n` by one (`n >>= 1`) to process the next bit.
    3. Return the counter.

---

### 4. Reverse Bits

- **Problem**: Reverse the bits of a 32-bit integer.
- **Technique**: Bit Manipulation
- **Steps**:
    1. Initialize a `result` variable to `0`.
    2. Iterate 32 times (for a 32-bit integer).
    3. In each iteration:
        - Left-shift the `result` by one (`result <<= 1`) to make space for the next bit.
        - Get the last bit of the input number `n` using `n & 1`.
        - Add this bit to the `result` using a bitwise OR (`|`).
        - Right-shift `n` by one (`n >>= 1`) to process its next bit.
    4. Return the `result`.

---

### 5. Sum of Two Integers

- **Problem**: Calculate the sum of two integers `a` and `b` without using the `+` and `-` operators.
- **Technique**: Bit Manipulation
- **Steps**:
    1. Use a `while` loop that continues as long as the `carry` (`b`) is not zero.
    2. Inside the loop:
        - Calculate the `carry` using `(a & b) << 1`. This finds the bits that are set in both `a` and `b` and shifts them left, which is the carry for the next position.
        - Calculate the sum without carry using `a ^ b`. This gives the sum for positions where at least one bit is not set.
        - Update `a` to be the sum (`a = a ^ b`) and `b` to be the `carry`.
    3. When the loop finishes (i.e., `carry` is `0`), `a` will hold the final sum.
    4. **Note**: In Python, you need to handle potential 32-bit integer overflow by using a mask.
