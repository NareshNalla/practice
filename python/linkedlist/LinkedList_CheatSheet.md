# Linked List Cheat Sheet

## 1. Reverse Linked List
**Goal:** Reverse pointers.
**Steps:**
1.  Init `prev = None`, `curr = head`.
2.  Loop: Save `next`, point `curr.next` to `prev`, move `prev` and `curr` forward.
3.  Return `prev`.
**Key:** 3-pointer swap (`prev`, `curr`, `next`).

## 2. Merge Two Sorted Lists
**Goal:** Merge two sorted lists into one.
**Steps:**
1.  **Dummy Node:** Create `dummy` head to simplify edge cases.
2.  **Iterate:** Compare `l1.val` vs `l2.val`. Append smaller to `current.next`. Move pointer.
3.  **Cleanup:** Append remaining non-empty list (`l1` or `l2`).
**Key:** Dummy head + simple comparison loop.

## 3. Detect Cycle
**Goal:** Check if cycle exists.
**Steps:**
1.  **Floyd's Tortoise & Hare:** Init `slow`, `fast` at head.
2.  **Loop:** `slow` moves 1 step, `fast` moves 2 steps.
3.  **Check:** If `slow == fast`, return `True`. If `fast` reaches end, return `False`.
**Key:** Fast pointer catches slow pointer if cycle exists.

## 4. Remove Nth Node From End
**Goal:** Remove node at `L - n`.
**Steps:**
1.  **Dummy Node:** Use dummy pointing to head (handles removing head).
2.  **Gap:** Move `fast` pointer `n + 1` steps ahead.
3.  **Slide:** Move `slow` and `fast` together until `fast` hits end.
4.  **Delete:** `slow.next = slow.next.next`.
**Key:** Maintain fixed gap of `n` between pointers.

## 5. Reorder List
**Goal:** L0 -> Ln -> L1 -> Ln-1...
**Steps:**
1.  **Middle:** Find middle using slow/fast pointers.
2.  **Reverse:** Reverse the second half of the list.
3.  **Merge:** Merge first half and reversed second half node by node.
**Key:** Find Mid -> Reverse 2nd Half -> Merge.
