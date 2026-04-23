# PriorityQueue in Java

`PriorityQueue` is an unbounded priority queue based on a priority heap. It processes elements based on their priority (natural ordering or via a `Comparator`) rather than their insertion order.

## Key Characteristics
- **Min-Heap by default**: The smallest element is at the head of the queue.
- **Max-Heap**: Can be created using `new PriorityQueue<>(Collections.reverseOrder())`.
- **Ordering**: Elements are ordered according to their natural ordering or by a provided `Comparator`.
- **Nulls**: Does not permit `null` elements.
- **Time Complexity**:
    - `offer(E e)` / `add(E e)`: $O(\log n)$
    - `poll()`: $O(\log n)$
    - `remove(Object o)`: $O(n)$
    - `peek()`: $O(1)$
    - `size()`: $O(1)$

## Useful Methods
- `add(E e)` / `offer(E e)`: Inserts the element into the priority queue.
- `peek()`: Retrieves, but does not remove, the head of this queue, or returns `null` if this queue is empty.
- `poll()`: Retrieves and removes the head of this queue, or returns `null` if this queue is empty.
- `size()`: Returns the number of elements in the collection.
- `isEmpty()`: Returns `true` if the queue contains no elements.
- `clear()`: Removes all elements.

---

## Practical Examples in this Package

### 1. [FindMedianInStream.java](problems/FindMedianInStream.java)
**Problem**: Maintain the median of a stream of numbers.
**Usage**: Uses two heaps to balance the data:
- A **Max-Heap** (`lo`) to store the smaller half of the numbers.
- A **Min-Heap** (`hi`) to store the larger half of the numbers.
The median is either the top of the larger heap or the average of both tops.

### 2. [KthLargestStream.java](problems/KthLargestStream.java)
**Problem**: Find the $K^{th}$ largest element in a stream.
**Usage**: Uses a **Min-Heap** of size $K$. 
- By keeping only $K$ elements in a Min-Heap, the "smallest" element in that heap (the root) is guaranteed to be the $K^{th}$ largest element overall.

### 3. [LastStoneWeight.java](problems/LastStoneWeight.java)
**Problem**: Repeatedly smash the two heaviest stones.
**Usage**: Uses a **Max-Heap**.
- Efficiently provides the two largest weights in $O(\log n)$ time.
- After smashing, the remaining weight (if any) is added back into the heap.
