package com.naresh.a_dsalgo.linkedlist.implementation.problems;

/**
 * Problem: Swap Nodes in Pairs
 * Description: Given a linked list, swap every two adjacent nodes and return its head.
 */
public class SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Algorithm: Use a dummy node to simplify head swapping. Maintain a 'prev' pointer 
     * and swap 'first' and 'second' nodes in each pair. Move 'prev' forward by two steps.
     */
    public ListNode swapPairs(ListNode head) {
        // Pattern: Iterative | Time: O(n), Space: O(1)
        var dummy = new ListNode(0, head);
        var prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            var first = prev.next;
            var second = prev.next.next;
            
            first.next = second.next; // Bridge first to third node
            second.next = first;      // Reverse the pair
            prev.next = second;       // Connect prev to the new first node
            
            prev = first; // Move prev two steps forward
        }
        return dummy.next;
    }
    // FAANG Tip: Mention that while recursion is cleaner (O(n) stack space), the iterative approach provides O(1) space which is often the interview requirement.

    public static void main(String[] args) {
        var sol = new SwapNodesInPairs();
        // Test: 1 -> 2 -> 3 -> 4
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        print(head);
        var res = sol.swapPairs(head);
        print(res); // Expected: 2 -> 1 -> 4 -> 3
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
}
