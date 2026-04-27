package com.naresh.a_dsalgo.af_linkedlist.problems;

/**
 * Problem: Reorder List
 * Description: Reorder a singly linked list L: L0→L1→…→Ln-1→Ln into L0→Ln→L1→Ln-1→L2→Ln-2→…
 */
public class ReorderList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Algorithm: 1. Find the middle using slow/fast pointers. 2. Reverse the second half 
     * of the list. 3. Merge the two halves by alternating nodes.
     */
    public void reorderList(ListNode head) {
        // Pattern: Mid + Reverse + Merge | Time: O(n), Space: O(1)
        if (head == null || head.next == null) return;

        // 1. Find middle
        var slow = head; var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode prev = null; var curr = slow.next;
        slow.next = null; // Split the list
        while (curr != null) {
            var nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // 3. Merge alternatingly
        var first = head; var second = prev;
        while (second != null) {
            var tmp1 = first.next;
            var tmp2 = second.next;//we can do with 1 temp. this after first done
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
    // FAANG Tip: This is a 3-in-1 problem (Midpoint + Reverse + Merge). Emphasize the importance of the slow/fast pointer technique and the O(1) space complexity by rearranging existing nodes.

    public static void main(String[] args) {
        var sol = new ReorderList();
        // Test: 1 -> 2 -> 3 -> 4 -> 5
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        print(head);
        sol.reorderList(head);
        print(head); // Expected: 1 -> 5 -> 2 -> 4 -> 3
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
}
