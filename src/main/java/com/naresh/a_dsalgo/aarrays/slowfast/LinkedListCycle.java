package com.naresh.a_dsalgo.aarrays.slowfast;

/**
 * Problem: Linked List Cycle
 * Description: Given head, the head of a linked list, determine if the linked list has a cycle in it.
 */
public class LinkedListCycle {

    /**
     * Algorithm: Use Floyd's Cycle-Finding Algorithm (Tortoise and Hare). 
     * Move slow pointer one step and fast pointer two steps. If they meet, 
     * a cycle exists. If fast reaches null, no cycle exists.
     */
    public boolean hasCycle(ListNode head) {
        // Pattern: Slow & Fast Pointers | Time: O(n), Space: O(1)
        if (head == null || head.next == null) return false;
        var slow = head;
        var fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null){
                return false; // End of list
            }
            slow = slow.next; // Move one step
            fast = fast.next.next; // Move two steps
        }
        return true; // Pointers met, cycle detected
    }
    // FAANG Tip: Mention that O(1) space is the key advantage over a HashSet approach. Explain that the fast pointer will eventually "lap" the slow pointer within the cycle.

    public static void main(String[] args) {
        var sol = new LinkedListCycle();
        // Setup Test: 1 -> 2 -> 3 -> 4 -> (back to 2)
        var n1 = new ListNode(1);
        var n2 = new ListNode(2);
        var n3 = new ListNode(3);
        var n4 = new ListNode(4);
        n1.next = n2; n2.next = n3; n3.next = n4;
        n4.next = n2; // Create cycle
        
        System.out.println("Has Cycle: " + sol.hasCycle(n1)); // Expected: true
        
        // Setup Test: 1 -> 2 -> null
        var n5 = new ListNode(1);
        var n6 = new ListNode(2);
        n5.next = n6;
        
        System.out.println("Has Cycle: " + sol.hasCycle(n5)); // Expected: false
    }
    // Internal ListNode class definition
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
