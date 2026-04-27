package com.naresh.a_dsalgo.af_linkedlist.problems;

/**
 * Problem: Reverse Linked List II
 * Description: Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Algorithm: Use a dummy node to handle 'left=1' edge case. Advance 'prev' to 
     * position 'left-1'. Use 'start' and 'then' pointers to reverse the sub-list 
     * by moving 'then' to the 'prev.next' position iteratively.
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Pattern: Iterative / Single Pass | Time: O(n), Space: O(1)
        if (head == null || left == right) return head;
        var dummy = new ListNode(0, head); // Dummy node for head-reversal cases
        var prev = dummy; 
        for (int i = 0; i < left - 1; i++) prev = prev.next; // Move to position left-1
        
        var start = prev.next; // Node at position 'left'
        var then = start.next; // Node to be moved to front of sub-list
        
        for (int i = 0; i < right - left; i++) {
            start.next = then.next; // Bridge over 'then'
            then.next = prev.next;  // Move 'then' to front of sub-list
            prev.next = then;       // Connect prev to new front
            then = start.next;      // Advance 'then' to next node to move
        }
        return dummy.next;
    }
    // FAANG Tip: Emphasize the "Dummy Node" pattern to simplify head changes. Discuss the O(1) space complexity and the single-pass nature as the optimal approach.
    //Single-pass O(1) space is the gold standard. Mention the "bridge and move" technique and why the dummy node is essential for the case where 'left = 1'.

    public static void main(String[] args) {
        var sol = new ReverseLinkedListII();
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        print(sol.reverseBetween(head, 2, 4)); // Expected: 1 -> 4 -> 3 -> 2 -> 5
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
}
