'''
You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
'''
from typing import Optional
from ListNode import ListNode
from LinkedListUtils import build_linked_list, print_linked_list

class ReorderList:
    #O(N) time, O(1)
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return

        # 1. Find the middle of the list
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        # 2. Reverse the second half
        second = slow.next
        slow.next = None # Break the link
        prev = None
        while second:
            tmp = second.next
            second.next = prev
            prev = second
            second = tmp
        
        # 3. Merge the two halves
        first, second = head, prev
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2

if __name__ == "__main__":
    solution = ReorderList()
    
    # Test Case 1
    head1 = build_linked_list([1, 2, 3, 4])
    print(f"Input: {print_linked_list(head1)}")
    solution.reorderList(head1)
    print(f"Output: {print_linked_list(head1)}") # Expected: [1, 4, 2, 3]
    print("-" * 20)

    # Test Case 2
    head2 = build_linked_list([1, 2, 3, 4, 5])
    print(f"Input: {print_linked_list(head2)}")
    solution.reorderList(head2)
    print(f"Output: {print_linked_list(head2)}") # Expected: [1, 5, 2, 4, 3]
