package com.naresh.a_dsalgo.af_linkedlist.problems;


/**
 * Problem: Linked List Cycle
 * Description: Given the head of a singly linked list, return true if there is a cycle in the linked list.
 * A cycle means that some node in the list can be reached again by continuously following the next pointer.
 */
public class LinkedListCycle {

    /**
     * Algorithm: Use Floyd's Cycle-Finding Algorithm (Tortoise and Hare).
     * One pointer (slow) moves one step at a time, and another pointer (fast) moves two steps at a time.
     * If there is a cycle, the fast pointer will eventually meet the slow pointer.
     */
    public boolean hasCycle(ListNode head) {
        // Pattern: Two Pointers (Floyd's Cycle-Finding) | Time: O(n), Space: O(1)
        if (head == null || head.next == null) return false; // No cycle if 0 or 1 node

        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Slow moves one step
            fast = fast.next.next;  // Fast moves two steps
            if (slow == fast) return true; // Cycle detected
        }
        return false; // Fast reached end, no cycle
    }
    // FAANG Tip: This is a classic algorithm. Be ready to explain why fast and slow pointers are guaranteed to meet in a cycle.

    public static void main(String[] args) {
        // Test Case 1: Cycle exists
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node_4 = new ListNode(-4);
        head1.next = node2;
        node2.next = node0;
        node0.next = node_4;
        node_4.next = node2; // Cycle: -4 points to 2

        var sol = new LinkedListCycle();
        System.out.println("Test Case 1 (Cycle): " + sol.hasCycle(head1)); // Expected: true

        // Test Case 2: No cycle
        ListNode head2 = new ListNode(1);
        ListNode node2_2 = new ListNode(2);
        head2.next = node2_2;
        System.out.println("Test Case 2 (No Cycle): " + sol.hasCycle(head2)); // Expected: false

        // Test Case 3: Single node, no cycle
        ListNode head3 = new ListNode(1);
        System.out.println("Test Case 3 (Single Node): " + sol.hasCycle(head3)); // Expected: false
    }
}

/**
 * Dry Run:
 * Input: head = [3,2,0,-4], pos = 1 (meaning -4 points to 2)
 *
 * 1. Initialization:
 *    head = 3 -> 2 -> 0 -> -4 -> (points back to 2)
 *    slow = head (3)
 *    fast = head (3)
 *
 * 2. Loop Iteration 1:
 *    - fast != null && fast.next != null (3.next != null) is true.
 *    - slow = slow.next (2)
 *    - fast = fast.next.next (0)
 *    - slow (2) == fast (0) is false.
 *
 * 3. Loop Iteration 2:
 *    - fast != null && fast.next != null (0.next != null) is true.
 *    - slow = slow.next (0)
 *    - fast = fast.next.next (-4)
 *    - slow (0) == fast (-4) is false.
 *
 * 4. Loop Iteration 3:
 *    - fast != null && fast.next != null (-4.next != null) is true.
 *    - slow = slow.next (-4)
 *    - fast = fast.next.next (2) (since -4.next is 2, and 2.next is 0)
 *    - slow (-4) == fast (2) is false.
 *
 * 5. Loop Iteration 4:
 *    - fast != null && fast.next != null (2.next != null) is true.
 *    - slow = slow.next (2)
 *    - fast = fast.next.next (-4) (since 2.next is 0, and 0.next is -4)
 *    - slow (2) == fast (-4) is false.
 *
 * 6. Loop Iteration 5:
 *    - fast != null && fast.next != null (-4.next != null) is true.
 *    - slow = slow.next (-4)
 *    - fast = fast.next.next (2) (since -4.next is 2, and 2.next is 0)
 *    - slow (-4) == fast (2) is false.
 *
 *    Wait, my manual trace of fast.next.next was incorrect. Let's re-trace from Iteration 4.
 *
 * Corrected Dry Run (from Iteration 4):
 * Input: head = [3,2,0,-4], pos = 1 (meaning -4 points to 2)
 *
 * 1. Initialization:
 *    head = 3 -> 2 -> 0 -> -4 -> (points back to 2)
 *    slow = head (3)
 *    fast = head (3)
 *
 * 2. Loop Iteration 1:
 *    - slow = 2
 *    - fast = 0
 *
 * 3. Loop Iteration 2:
 *    - slow = 0
 *    - fast = -4
 *
 * 4. Loop Iteration 3:
 *    - slow = -4
 *    - fast = 0 (fast was at -4, fast.next is 2, fast.next.next is 0)
 *    - slow (-4) == fast (0) is false.
 *
 * 5. Loop Iteration 4:
 *    - slow = 2 (slow was at -4, slow.next is 2)
 *    - fast = 2 (fast was at 0, fast.next is -4, fast.next.next is 2)
 *    - slow (2) == fast (2) is true. Return true.
 *
 * 6. Result: true
 */
