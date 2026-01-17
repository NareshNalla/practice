# Dynamic Programming Cheat Sheet

## 1. Climbing Stairs
**Technique:** 1D DP (Fibonacci)
**Goal:** Ways to reach step `n`.
**Steps:**
1.  **Base:** `n=1` -> 1, `n=2` -> 2.
2.  **Recurrence:** `ways(n) = ways(n-1) + ways(n-2)`.
3.  **Opt:** Use 2 vars (`one`, `two`) instead of array.
**Key:** Fibonacci.

## 2. Coin Change
**Technique:** Unbounded Knapsack (Bottom-Up)
**Goal:** Min coins for `amount`.
**Steps:**
1.  **Init:** `dp` array size `amount+1` with `inf`. `dp[0] = 0`.
2.  **Loop:** `1` to `amount`. Inner loop: `coins`.
3.  **Recurrence:** `dp[a] = min(dp[a], 1 + dp[a - coin])`.
**Key:** Bottom-up, `1 + dp[remainder]`.

## 3. Combination Sum
**Technique:** Backtracking (DFS)
**Goal:** Unique combos summing to target (reuse allowed).
**Steps:**
1.  **DFS:** `dfs(index, current_combo, current_sum)`.
2.  **Base:** `sum == target` (add copy), `sum > target` or `index >= len` (return).
3.  **Branch:**
    *   **Include:** Add `nums[i]`, recurse `dfs(i, ...)` (stay same index).
    *   **Skip:** Pop, recurse `dfs(i+1, ...)` (next index).
**Key:** Backtracking, decision tree (include vs skip).

## 4. Decode Ways
**Technique:** 1D DP (Memoization)
**Goal:** Ways to decode digits to letters.
**Steps:**
1.  **Init:** `dp = {len(s): 1}`.
2.  **DFS/Iter:** `dfs(i)`.
    *   If `s[i] == '0'`, return 0.
    *   `res = dfs(i+1)` (1 digit).
    *   If `10 <= int(s[i:i+2]) <= 26`, `res += dfs(i+2)` (2 digits).
**Key:** 1-digit vs 2-digit valid check.

## 5. House Robber
**Technique:** 1D DP (Space Optimized)
**Goal:** Max loot, no adjacent.
**Steps:**
1.  **Vars:** `rob1` (prev-prev), `rob2` (prev).
2.  **Loop:** `temp = max(n + rob1, rob2)`.
3.  **Shift:** `rob1 = rob2`, `rob2 = temp`.
**Key:** `max(current + prev_prev, prev)`.

## 6. House Robber II
**Technique:** 1D DP (Circular)
**Goal:** Circular houses.
**Steps:**
1.  **Split:** Problem becomes linear `House Robber` on two subarrays:
    *   `nums[0 : n-1]` (Include first, exclude last).
    *   `nums[1 : n]` (Exclude first, include last).
2.  **Result:** `max(rob(sub1), rob(sub2))`.
**Key:** Break circle into two linear problems.

## 7. Jump Game
**Technique:** Greedy
**Goal:** Can reach last index?
**Steps:**
1.  **Greedy:** Set `goal = last_index`.
2.  **Loop:** Backwards from `n-2` to `0`.
3.  **Check:** If `i + nums[i] >= goal`, shift `goal = i`.
4.  **Result:** `goal == 0`.
**Key:** Shift goal post backwards.

## 8. Longest Common Subsequence
**Technique:** 2D DP
**Goal:** Len of LCS.
**Steps:**
1.  **Grid:** `dp[m+1][n+1]` zeros.
2.  **Loop:** Nested `i`, `j`.
    *   Match: `dp[i][j] = 1 + dp[i-1][j-1]` (diagonal).
    *   No Match: `dp[i][j] = max(dp[i-1][j], dp[i][j-1])` (left or top).
**Key:** 2D Grid, Diagonal vs Max(Top, Left).

## 9. Longest Increasing Subsequence
**Technique:** Binary Search (Patience Sorting)
**Goal:** Len of LIS.
**Steps:**
1.  **Patience Sort:** Maintain list `sub`.
2.  **Loop:** For `x` in `nums`:
    *   If `x > sub[-1]`: Append.
    *   Else: Binary search (`bisect_left`) in `sub`, replace first element `>= x`.
**Key:** Replace to keep tails small. O(N log N).

## 10. Unique Paths
**Technique:** 2D DP (Space Optimized)
**Goal:** Paths from top-left to bottom-right.
**Steps:**
1.  **Row:** Init `row` size `n` with 1s.
2.  **Loop:** `m-1` times.
    *   Inner loop `n-2` to `0`: `newRow[j] = newRow[j+1] (right) + row[j] (down)`.
3.  **Update:** `row = newRow`.
**Key:** `cell = right + down`.

## 11. Word Break
**Technique:** 1D DP
**Goal:** Can segment string?
**Steps:**
1.  **DP:** `dp[n+1]` False, `dp[0] = True`.
2.  **Loop:** `i` from 1 to `n`. Inner `j` from 0 to `i`.
3.  **Check:** If `dp[j]` is True AND `s[j:i]` in `wordDict`:
    *   `dp[i] = True`, break.
**Key:** `dp[i]` means prefix `i` is valid.
