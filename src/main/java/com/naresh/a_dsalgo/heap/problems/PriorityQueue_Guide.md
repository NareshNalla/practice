# PriorityQueue in Java & Heap Patterns

This document provides a guide to the `PriorityQueue` class in Java and summarizes common patterns for solving heap-related problems, ordered from foundational to advanced concepts.

---

## 1. What is a PriorityQueue?

A `PriorityQueue` is an unbounded priority queue based on a priority heap. It processes elements based on their priority (natural ordering or via a `Comparator`) rather than their insertion order.

### Key Characteristics
- **Min-Heap by default**: The smallest element is at the head.
- **Max-Heap**: Created using `new PriorityQueue<>(Collections.reverseOrder())`.
- **Time Complexity**:
    - `offer(E e)` / `poll()`: $O(\log n)$
    - `peek()`: $O(1)$
- **Constraint**: Does not permit `null` elements.

### Useful Methods
- `offer(E e)`: Adds element to queue.
- `peek()`: Retrieves head without removing (returns `null` if empty).
- `poll()`: Retrieves and removes head (returns `null` if empty).
- `size()`: Returns number of elements.
- `isEmpty()`: Returns true if no elements.

---

## 2. Heap Problem Patterns (Easy to Hard)

### Pattern 1: Basic Heap for Greedy Processing (Easy)
**Problem**: [LastStoneWeight.java](./LastStoneWeight.java) - Smash the two heaviest stones repeatedly.

- **Concept**: Always needing the "extreme" (largest or smallest) elements.
- **Technique**: Max-Heap.
- **Steps**:
    1. Insert all weights into a **Max-Heap**.
    2. While more than 1 stone remains:
        - `poll()` the two largest stones.
        - If weights differ, `offer()` the difference back into the heap.
    3. Return the last stone weight or 0.

### Pattern 2: Fixed-Size Heap for Top-K (Medium)
**Problem**: [KthLargestStream.java](./KthLargestStream.java) - Find the $K^{th}$ largest element in a live stream.

- **Concept**: Maintaining only the "Top-K" elements.
- **Technique**: Min-Heap of size $K$.
- **FAANG Tip**: In a Min-Heap of size $K$, the root is the smallest of the largest $K$ elements, which is exactly the $K^{th}$ largest overall.
- **Steps**:
    1. Add new element to the **Min-Heap**.
    2. If heap size > $K$, `poll()` (remove the smallest).
    3. The `peek()` value is always the $K^{th}$ largest.

### Pattern 3: Two-Heaps for Dynamic Median (Hard)
**Problem**: [FindMedianInStream.java](./FindMedianInStream.java) - Maintain the median of a live stream.

- **Concept**: Balancing two halves of data to find the center.
- **Technique**: Two Heaps (Max-Heap + Min-Heap).
- **FAANG Tip**: 
    - **Max-Heap** stores the **lower half** (small numbers).
    - **Min-Heap** stores the **upper half** (large numbers).
    - Keep sizes balanced (difference $\le 1$). Odd total: the bigger heap's root IS the median. Even total: average both roots.
- **Steps**:
    1. `addNum(num)`:
        - Add to Max-Heap, then move Max-Heap's top to Min-Heap (ensures sorting).
        - If Min-Heap is larger, move its top back to Max-Heap (ensures balance).
    2. `findMedian()`:
        - If sizes are unequal, the larger heap's top is the median.
        - If equal, average of both tops.

---

## 3. Agent Skill: Documentation Generator

### System Prompt for Summary Documentation
Use this prompt to generate revision notes for any topic (Trees, Heaps, DP, etc.):

> Act as an expert technical writer. Create a summary document for the problems I solved in [TOPIC]. For each problem, include:
> 1. **Problem**: Clear, one-sentence goal.
> 2. **Technique**: The specific algorithm or data structure used.
> 3. **FAANG Tip**: The key intuition, pattern name, or common interview trick.
> 4. **Complexity**: Big O for Time and Space.
> 5. **Steps**: Bulleted list of high-level logic (1-5 steps).
>
> Follow the layout of `python_tree_revision.md`. Order problems by concept complexity (Foundational -> Advanced).

### Pattern Recognition Guide
- **Top-K elements?** -> Min-heap of size $K$.
- **Dynamic Median / Balancing?** -> Two heaps.
- **Greedy Extremes?** -> Single heap.
- **Merging Sorted Lists?** -> Min-heap with pointers.
- **Task Scheduling / Frequency?** -> Map + Max-Heap.
