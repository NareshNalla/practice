package com.naresh.a_dsalgo.linkedlist.implementation.problems;

/**
 * Problem: Reverse Linked List
 * Description: Reverse a singly linked list.
 */
public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Algorithm: Iterate through the list, changing the next pointer of each node
     * to point to its previous node. Use prev, curr, and nextTemp pointers.
     */
    public ListNode reverseList(ListNode head) {
        // Pattern: Iterative | Time: O(n), Space: O(1)
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; // Store next node
            curr.next = prev;              // Reverse pointer
            prev = curr;                   // Advance prev
            curr = nextTemp;               // Advance curr
        }
        return prev;
    }
    // FAANG Tip: Iterative approach is O(1) space, making it superior to recursion (O(n) stack) for large lists. Mention the "three-pointer" shuffle as the core mechanic.

    public static void main(String[] args) {
        var sol = new ReverseLinkedList();
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        print(sol.reverseList(head)); // Expected: 5 -> 4 -> 3 -> 2 -> 1
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
       /*
    1.
prev = curr;: We are updating the prev pointer to point to the node that was just the "current" one. So, prev moves to the curr position.
2.
curr = nextTemp;: We are updating the curr pointer to point to the next node in the original sequence (which we saved in nextTemp). So, curr moves to the next position.
     */
}
