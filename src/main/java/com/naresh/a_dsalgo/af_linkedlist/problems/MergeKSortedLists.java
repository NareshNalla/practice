package com.naresh.a_dsalgo.af_linkedlist.problems;

import java.util.PriorityQueue;
import java.util.function.Function; // Keep Function for createList if needed

/**
 * Problem: Merge k Sorted Lists
 * Description: Merge k sorted linked lists into one sorted linked list.
 */
public class MergeKSortedLists {

    /**
     * Algorithm: Use a min-priority queue to efficiently find the smallest node among the heads of all k lists.
     * 1. Initialize a dummy head for the merged list and a current pointer.
     * 2. Add the head of each non-null list to the priority queue.
     * 3. While the priority queue is not empty:
     *    a. Extract the node with the smallest value from the priority queue.
     *    b. Append this node to the merged list.
     *    c. If the extracted node has a next node, add it to the priority queue.
     * 4. Return the next of the dummy head.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // Pattern: Priority Queue / Min-Heap | Time: O(N log k), Space: O(k)
        if (lists == null || lists.length == 0) return null;
        // Min-priority queue to store the head of each list, ordered by node value
        var pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        // Add the head of each list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        var dummyHead = new ListNode(0); // Dummy node to simplify merged list construction
        var current = dummyHead;
        while (!pq.isEmpty()) {
            var smallest = pq.poll(); // Get the smallest node
            current.next = smallest;  // Append to merged list
            current = current.next;   // Move current pointer
            if (smallest.next != null) {
                pq.add(smallest.next); // Add the next node from the list it came from
            }
        }
        return dummyHead.next; // The actual head of the merged list
    }
    // FAANG Tip: This approach is efficient because it avoids repeatedly scanning all k lists. The time complexity is dominated by N (total nodes) * log k (PQ operations).

    public static void main(String[] args) {
        var sol = new MergeKSortedLists();

        // Helper to create a linked list from an array
        Function<int[], ListNode> createList = arr -> {
            if (arr == null || arr.length == 0) return null;
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            for (int val : arr) {
                curr.next = new ListNode(val);
                curr = curr.next;
            }
            return dummy.next;
        };

        // Test Case 1: Example from LeetCode
        ListNode l1 = createList.apply(new int[]{1, 4, 5});
        ListNode l2 = createList.apply(new int[]{1, 3, 4});
        ListNode l3 = createList.apply(new int[]{2, 6});
        ListNode[] lists1 = {l1, l2, l3};
        System.out.println("Input Lists: ");
        for (ListNode list : lists1) printList(list); // Using the separate method
        ListNode merged1 = sol.mergeKLists(lists1);
        System.out.print("Merged List: ");
        printList(merged1); // Using the separate method

        // Test Case 2: Empty lists
        ListNode[] lists2 = {};
        System.out.println("\nTest Case 2 (Empty lists):");
        ListNode merged2 = sol.mergeKLists(lists2);
        System.out.print("Merged List: ");
        printList(merged2); // Using the separate method

        // Test Case 3: List with nulls
        ListNode l4 = createList.apply(new int[]{1});
        ListNode l5 = null;
        ListNode l6 = createList.apply(new int[]{0});
        ListNode[] lists3 = {l4, l5, l6};
        System.out.println("\nTest Case 3 (Lists with nulls):");
        System.out.print("Input Lists: ");
        for (ListNode list : lists3) printList(list); // Using the separate method
        ListNode merged3 = sol.mergeKLists(lists3);
        System.out.print("Merged List: ");
        printList(merged3); // Using the separate method
    }
    /**
     *
     * Helper method to print a linked list.
     * @param head The head of the linked list to print.
     */
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}

/**
 * Dry Run:
 * Input: lists = [[1,4,5], [1,3,4], [2,6]]
 *
 * 1. Initialization:
 *    pq = PriorityQueue (min-heap)
 *    dummyHead = ListNode(0)
 *    current = dummyHead
 *
 * 2. Populate PQ:
 *    - Add 1 (from list1) to pq. pq = {1(l1)}
 *    - Add 1 (from list2) to pq. pq = {1(l1), 1(l2)}
 *    - Add 2 (from list3) to pq. pq = {1(l1), 1(l2), 2(l3)}
 *    (Note: 1(l1) and 1(l2) are distinct nodes, order in PQ might vary but min is always correct)
 *
 * 3. Process PQ:
 *    - **Poll 1 (from l1)**:
 *      - smallest = 1(l1)
 *      - current.next = 1(l1). Merged: 0 -> 1(l1)
 *      - current = 1(l1)
 *      - Add 4 (from l1.next) to pq. pq = {1(l2), 2(l3), 4(l1)}
 *
 *    - **Poll 1 (from l2)**:
 *      - smallest = 1(l2)
 *      - current.next = 1(l2). Merged: 0 -> 1(l1) -> 1(l2)
 *      - current = 1(l2)
 *      - Add 3 (from l2.next) to pq. pq = {2(l3), 3(l2), 4(l1)}
 *
 *    - **Poll 2 (from l3)**:
 *      - smallest = 2(l3)
 *      - current.next = 2(l3). Merged: 0 -> 1(l1) -> 1(l2) -> 2(l3)
 *      - current = 2(l3)
 *      - Add 6 (from l3.next) to pq. pq = {3(l2), 4(l1), 6(l3)}
 *
 *    - **Poll 3 (from l2)**:
 *      - smallest = 3(l2)
 *      - current.next = 3(l2). Merged: ... -> 2(l3) -> 3(l2)
 *      - current = 3(l2)
 *      - Add 4 (from l2.next) to pq. pq = {4(l1), 4(l2), 6(l3)}
 *
 *    - **Poll 4 (from l1)**:
 *      - smallest = 4(l1)
 *      - current.next = 4(l1). Merged: ... -> 3(l2) -> 4(l1)
 *      - current = 4(l1)
 *      - 4(l1).next is 5. Add 5 (from l1.next) to pq. pq = {4(l2), 5(l1), 6(l3)}
 *
 *    - **Poll 4 (from l2)**:
 *      - smallest = 4(l2)
 *      - current.next = 4(l2). Merged: ... -> 4(l1) -> 4(l2)
 *      - current = 4(l2)
 *      - 4(l2).next is null. Do not add to pq. pq = {5(l1), 6(l3)}
 *
 *    - **Poll 5 (from l1)**:
 *      - smallest = 5(l1)
 *      - current.next = 5(l1). Merged: ... -> 4(l2) -> 5(l1)
 *      - current = 5(l1)
 *      - 5(l1).next is null. Do not add to pq. pq = {6(l3)}
 *
 *    - **Poll 6 (from l3)**:
 *      - smallest = 6(l3)
 *      - current.next = 6(l3). Merged: ... -> 5(l1) -> 6(l3)
 *      - current = 6(l3)
 *      - 6(l3).next is null. Do not add to pq. pq = {}
 *
 * 4. PQ is empty. Loop ends.
 *
 * 5. Return dummyHead.next (which is 1(l1)).
 *
 * 6. Final Merged List: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> null
 */
