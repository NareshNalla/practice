# Arrays Cheat Sheet

## 1. Two Sum
**Technique:** Hash Map
**Goal:** Indices of two nums summing to target.
**Steps:**
1.  **Map:** Init `prevMap` (val -> index).
2.  **Iterate:** For `n` in `nums`:
    *   `diff = target - n`.
    *   If `diff` in map, return `[prevMap[diff], i]`.
    *   Store `prevMap[n] = i`.
**Key:** Hash Map for O(1) lookup of complement.

## 2. Best Time to Buy and Sell Stock
**Technique:** Sliding Window (One Pass)
**Goal:** Max profit (one transaction).
**Steps:**
1.  **Vars:** `min_price = inf`, `max_profit = 0`.
2.  **Iterate:** For `price` in `prices`:
    *   `min_price = min(min_price, price)`.
    *   `max_profit = max(max_profit, price - min_price)`.
**Key:** Track lowest price seen so far.

## 3. Contains Duplicate
**Technique:** Hash Set
**Goal:** True if any value appears twice.
**Steps:**
1.  **Set:** Init `seen = set()`.
2.  **Iterate:** If `n` in `seen`, return `True`. Else add to `seen`.
**Key:** Hash Set for O(1) lookup.

## 4. Product of Array Except Self
**Technique:** Prefix & Suffix Arrays
**Goal:** Product of all except `self` (no division).
**Steps:**
1.  **Prefix:** Pass 1 (L->R): `res[i] = prefix`. Update `prefix *= nums[i]`.
2.  **Suffix:** Pass 2 (R->L): `res[i] *= postfix`. Update `postfix *= nums[i]`.
**Key:** Prefix * Postfix.

## 5. Maximum Subarray
**Technique:** Kadane's Algorithm
**Goal:** Largest sum contiguous subarray.
**Steps:**
1.  **Kadane's:** Init `maxSub = nums[0]`, `curSum = 0`.
2.  **Iterate:**
    *   If `curSum < 0`, reset `curSum = 0`.
    *   `curSum += n`.
    *   `maxSub = max(maxSub, curSum)`.
**Key:** Reset negative prefix.

## 6. Maximum Product Subarray
**Technique:** Dynamic Programming (Track Min/Max)
**Goal:** Largest product contiguous subarray.
**Steps:**
1.  **Vars:** `curMax = 1`, `curMin = 1`, `res = max(nums)`.
2.  **Iterate:**
    *   If `n == 0`, reset `curMax, curMin = 1`.
    *   `tmp = curMax * n`.
    *   `curMax = max(n * curMax, n * curMin, n)`.
    *   `curMin = min(tmp, n * curMin, n)`.
    *   `res = max(res, curMax)`.
**Key:** Track Min and Max (negatives flip signs).

## 7. Find Minimum in Rotated Sorted Array
**Technique:** Binary Search
**Goal:** Min element in rotated array (O(log n)).
**Steps:**
1.  **Binary Search:** `l = 0`, `r = len-1`.
2.  **Loop:** While `l < r`:
    *   `mid = (l + r) // 2`.
    *   If `nums[mid] > nums[r]`: Min is in right (`l = mid + 1`).
    *   Else: Min is in left (`r = mid`).
**Key:** Compare mid with right boundary.

## 8. Search in Rotated Sorted Array
**Technique:** Binary Search
**Goal:** Index of target (O(log n)).
**Steps:**
1.  **Binary Search:** `l, r`.
2.  **Check Sorted Half:**
    *   If `nums[l] <= nums[mid]` (Left sorted):
        *   If `target` in `[l, mid]`, `r = mid - 1`. Else `l = mid + 1`.
    *   Else (Right sorted):
        *   If `target` in `[mid, r]`, `l = mid + 1`. Else `r = mid - 1`.
**Key:** Identify sorted half, check range.

## 9. 3Sum
**Technique:** Two Pointers (Sorted)
**Goal:** Unique triplets summing to 0.
**Steps:**
1.  **Sort:** `nums.sort()`.
2.  **Iterate:** `i` from `0` to `len-2`. Skip duplicates (`i > 0 and nums[i] == nums[i-1]`).
3.  **Two Pointers:** `l = i+1`, `r = len-1`.
    *   `sum = nums[i] + nums[l] + nums[r]`.
    *   If `> 0`: `r--`. If `< 0`: `l++`.
    *   If `== 0`: Add result, `l++`, skip duplicates (`nums[l] == nums[l-1]`).
**Key:** Sort + Fix one + Two Sum II.

## 10. Container With Most Water
**Technique:** Two Pointers (Greedy)
**Goal:** Max area between lines.
**Steps:**
1.  **Two Pointers:** `l = 0`, `r = len-1`.
2.  **Loop:** While `l < r`:
    *   `area = (r - l) * min(height[l], height[r])`.
    *   `res = max(res, area)`.
    *   Move pointer of smaller height (`l++` or `r--`).
**Key:** Maximize width, greedily discard shorter line.

## 11. Minimum Subarray Sum (>= k)
**Technique:** Sliding Window (Variable)
**Goal:** Min length subarray with sum >= k.
**Steps:**
1.  **Sliding Window:** `l = 0`, `total = 0`, `res = inf`.
2.  **Expand:** `total += nums[r]`.
3.  **Shrink:** While `total >= k`:
    *   `res = min(res, r - l + 1)`.
    *   `total -= nums[l]`, `l++`.
**Key:** Variable sliding window.

## 12. Max Sum in K Size
**Technique:** Sliding Window (Fixed)
**Goal:** Max sum of subarray size k.
**Steps:**
1.  **Init:** `curSum = sum(nums[:k])`.
2.  **Slide:** Iterate `i` from `k` to `len`.
    *   `curSum += nums[i] - nums[i-k]`.
    *   `maxSum = max(maxSum, curSum)`.
**Key:** Fixed sliding window (add new, remove old).
