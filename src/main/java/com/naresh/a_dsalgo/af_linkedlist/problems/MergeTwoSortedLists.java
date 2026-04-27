package com.naresh.a_dsalgo.af_linkedlist.problems;

/**
 * Problem: Merge Two Sorted Lists
 * Description: Merge two sorted linked lists and return it as a sorted list.
 */
public class MergeTwoSortedLists {


    /**
     * Algorithm: Use a dummy node and a tail pointer. Iterate through both lists, 
     * attaching the smaller node to the tail. After the loop, attach any remaining 
     * nodes from either list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Pattern: Dummy Node / Iterative | Time: O(n + m), Space: O(1)
        var dummy = new ListNode(0);
        var merge = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                merge.next = list1; // Attach list1 node
                list1 = list1.next;
            } else {
                merge.next = list2; // Attach list2 node
                list2 = list2.next;
            }
            merge = merge.next; // Advance merge
        }
        
        merge.next = (list1 != null) ? list1 : list2; // Attach remaining elements
        return dummy.next;
    }
    // FAANG Tip: Dummy nodes simplify edge cases (like empty lists). Mention that O(1) space is achieved by rearranging pointers rather than creating new nodes.

    public static void main(String[] args) {
        var sol = new MergeTwoSortedLists();
        
        // List 1: 1 -> 2 -> 4
        var l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        // List 2: 1 -> 3 -> 4
        var l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        print(l1);
        print(l2);
        var merged = sol.mergeTwoLists(l1, l2);
        print(merged); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
