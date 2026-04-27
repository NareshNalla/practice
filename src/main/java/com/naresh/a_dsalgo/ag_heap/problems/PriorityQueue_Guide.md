# PriorityQueue in Java & Heap Patterns

This document provides a guide to the `PriorityQueue` class in Java and summarizes common patterns for solving heap-related problems.

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
- **Problem**: [LastStoneWeight.java](./LastStoneWeight.java) - Smash the two heaviest stones repeatedly.
- **FAANG Pattern**: "Greedy Extreme Tracking"
- **Method Logic**:
    1. Insert all weights into a **Max-Heap**.
    2. While more than 1 stone remains, `poll()` the two largest and `offer()` the difference back.
    3. Final `poll()` or 0 is the answer.
- **Complexity**: Time: $O(n \log n)$ | Space: $O(n)$

### Pattern 2: Fixed-Size Heap for Top-K (Medium)
- **Problem**: [KthLargestStream.java](./KthLargestStream.java) - Find the $K^{th}$ largest element in a live stream.
- **FAANG Pattern**: "Fixed-Size Min-Heap"
- **Method Logic**:
    1. Maintain a **Min-Heap** of size $K$.
    2. New elements are added; if size > $K$, the smallest (root) is removed.
    3. The root (`peek()`) is always the $K^{th}$ largest element.
- **Complexity**: Time: $O(\log K)$ per add | Space: $O(K)$

### Pattern 3: Two-Heaps for Dynamic Median (Hard)
- **Problem**: [FindMedianInStream.java](./FindMedianInStream.java) - Maintain the median of a live stream.
- **FAANG Pattern**: "Two-Heap Balancing"
- **Method Logic**:
    1. **Max-Heap** stores the lower half; **Min-Heap** stores the upper half.
    2. Balance sizes so they differ by at most 1.
    3. Median is either the top of the larger heap or the average of both tops.
- **Complexity**: Time: $O(\log n)$ add, $O(1)$ median | Space: $O(n)$

---

## 3. Agent Skill: Documentation Standards (Java DSA)

When updating Java files or creating summaries, follow these rules:

### 1. Java Class-Level Javadoc
- **Problem**: Clear title of the algorithm/problem.
- **Description**: Concise summary of what the code achieves.
- **Note**: Do *not* include strategy or patterns here.

### 2. Java Method-Level Javadoc
- **FAANG Pattern**: The conceptual name of the pattern (e.g., "Two-Pointer", "Monotonic Stack").
- **Strategy**: Step-by-step logic of the implementation.
- **Complexity**: Explicit Big O for Time and Space.

### 3. Summary Markdown Template
Use this structure for MD revision files:
```markdown
### [Problem Name]
- **Problem**: [One-sentence goal]
- **FAANG Pattern**: [Pattern Name]
- **Method Logic**: [1-3 bullet points on the "How"]
- **Complexity**: Time: [O(...)] | Space: [O(...)]
```
