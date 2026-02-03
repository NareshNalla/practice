# Binary Problems Revision Cheat Sheet

| Problem | Technique | Thinking / Hint | Minimal Steps |
| :--- | :--- | :--- | :--- |
| **[Counting Bits](CountingBits.py)** | **DP + LSB** | The number of 1s in `i` is the same as `i // 2`, plus 1 if `i` is odd. | 1. Init `ans` array.<br>2. Loop `i` from 1 to `n`.<br>3. `ans[i] = ans[i >> 1] + (i & 1)` |
| **[Missing Number](MissingNumber.py)** | **XOR** | `A ^ A = 0`. XORing all indices `[0..n]` with all values `nums` leaves only the missing number. | 1. Init `res = n`.<br>2. Loop `i, v` in `nums`.<br>3. `res ^= i ^ v` |
| **[Number of 1 Bits](NumberOf1Bits.py)** | **Brian Kernighan** | `n & (n - 1)` always removes the rightmost set bit (1). | 1. Loop while `n > 0`.<br>2. `n &= (n - 1)`.<br>3. `count += 1` |
| **[Reverse Bits](ReverseBits.py)** | **Iterate & Shift** | Build result by pushing `n`'s LSB into `res`'s LSB, then shifting `res` left. | 1. Loop 32 times.<br>2. `res = (res << 1) | (n & 1)`<br>3. `n >>= 1` |
| **[Sum of Two Integers](SumofTwoIntegers.py)** | **Logic (Half Adder)** | `a ^ b` is sum without carry. `(a & b) << 1` is carry. Repeat until no carry. | 1. Loop while `b != 0` (mask to 32-bit).<br>2. `sum = (a ^ b) & mask`<br>3. `carry = ((a & b) << 1) & mask` |

---

### Key Bitwise Concepts
- **`x & (x - 1)`**: Drops lowest set bit.
- **`x & -x`**: Gets lowest set bit.
- **`x ^ x = 0`**: Self-cancellation.
- **`x << 1`**: Multiply by 2.
- **`x >> 1`**: Divide by 2.
