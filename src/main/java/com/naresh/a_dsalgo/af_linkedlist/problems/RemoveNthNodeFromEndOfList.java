package com.naresh.a_dsalgo.af_linkedlist.problems;

/**
 * Problem: Remove Nth Node From End of List
 * Description: Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEndOfList {


    /**
     * Algorithm: Use two pointers (fast and slow) and a dummy node. Advance fast
     * by n steps. Then, move both fast and slow together until fast reaches the end.
     * slow will then point to the node just before the nth node.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Pattern: Two Pointers (Fixed Gap) | Time: O(n), Space: O(1)
        var dummy = new ListNode(0, head); // Handles cases like removing head
        var back = dummy;
        var front = dummy;
        // 1. Advance front so that there's a gap of n nodes between back and front
        for (int i = 0; i <= n; i++) {
            front = front.next;
        }
        // 2. Move both together until front reaches the end
        while (front != null) {
            back = back.next;
            front = front.next;
        }
        // 3. Skip the nth node
        back.next = back.next.next;
        return dummy.next;
    }
    // FAANG Tip: Use the "Gap" technique to solve "from-end" problems in a single pass. Mention why the dummy node is crucial for edge cases where the head needs to be removed.

    public static void main(String[] args) {
        var sol = new RemoveNthNodeFromEndOfList();
        // Test: 1 -> 2 -> 3 -> 4 -> 5, n=2
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        print(head);
        var res = sol.removeNthFromEnd(head, 2);
        print(res); // Expected: 1 -> 2 -> 3 -> 5
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
}
