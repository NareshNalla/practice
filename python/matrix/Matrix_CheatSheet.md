# Matrix Cheat Sheet

## 1. Rotate Image (90 deg clockwise)
**Goal:** Rotate in-place.
**Steps:**
1.  **Transpose:** Swap `matrix[i][j]` with `matrix[j][i]`. (Rows become columns).
2.  **Reverse:** Reverse each row.
**Key:** Transpose -> Reverse Rows.

## 2. Spiral Matrix
**Goal:** Traverse in spiral order.
**Steps:**
1.  **Boundaries:** Init `left, right, top, bottom`.
2.  **Loop:** While `left < right` and `top < bottom`:
    *   Top row (L->R), `top++`.
    *   Right col (T->B), `right--`.
    *   Check break condition.
    *   Bottom row (R->L), `bottom--`.
    *   Left col (B->T), `left++`.
**Key:** 4 pointers, shrink boundaries.

## 3. Set Matrix Zeroes
**Goal:** Set row/col to 0 if cell is 0 (O(1) space).
**Steps:**
1.  **Mark:** Use Row 0 and Col 0 as flags.
    *   If `matrix[r][c] == 0`, set `matrix[0][c] = 0` and `matrix[r][0] = 0`.
    *   Use separate `rowZero` var for `matrix[0][0]` overlap.
2.  **Update Inner:** Iterate `(1,1)` to end. If marker is 0, set cell to 0.
3.  **Update Markers:** Handle Col 0 then Row 0 based on flags.
**Key:** Use first row/col as storage.

## 4. Word Search
**Goal:** Find word path (DFS).
**Steps:**
1.  **Iterate:** Loop through every cell. If match first char, start DFS.
2.  **DFS(r, c, i):**
    *   **Base:** If `i == len`, return True.
    *   **Boundaries:** Check bounds, mismatch, or visited (`path` set).
    *   **Recurse:** Add to `path`. Check 4 directions.
    *   **Backtrack:** Remove from `path`.
**Key:** DFS + Backtracking (mark visited).
