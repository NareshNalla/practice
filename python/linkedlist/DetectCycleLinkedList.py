'''
https://leetcode.com/problems/linked-list-cycle/
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

Input: head = [3,2,0,-4],
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
'''
from typing import Optional
from ListNode import ListNode
from LinkedListUtils import build_linked_list

class LinkedListCycle:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow, fast = head , head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False
    
    def hasCycle1(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return False
        slow = head
        fast = head.next
        while slow != fast:
            if not fast or not fast.next:
                return False
            slow = slow.next
            fast = fast.next.next
        return True

if __name__ == "__main__":
    solution = LinkedListCycle()

    # Test Case 1: Cycle exists
    # List: 3 -> 2 -> 0 -> -4
    # Cycle: -4 -> 2
    head1 = build_linked_list([3, 2, 0, -4])
    
    # Create cycle manually
    # Get reference to node with value 2 (index 1)
    cycle_entry = head1.next 
    # Get reference to tail node (-4)
    tail = head1.next.next.next
    # Connect tail to cycle entry
    tail.next = cycle_entry
    
    print(f"Test Case 1 (Cycle): {solution.hasCycle1(head1)}") # Expected: True

    # Test Case 2: No cycle
    # List: 1 -> 2
    head2 = build_linked_list([1, 2])
    print(f"Test Case 2 (No Cycle): {solution.hasCycle(head2)}") # Expected: False
    
    # Test Case 3: Single node, no cycle
    head3 = build_linked_list([1])
    print(f"Test Case 3 (Single Node): {solution.hasCycle(head3)}") # Expected: False
