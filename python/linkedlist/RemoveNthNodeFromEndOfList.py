'''
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Follow up: Could you do this in one pass?
'''
from typing import Optional
from ListNode import ListNode
from LinkedListUtils import build_linked_list, print_linked_list

class RemoveNthNodeFromEndOfList:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        # Dummy node to handle edge cases (e.g., removing the head)
        dummy = ListNode(0, head)
        slow = dummy
        fast = dummy
        
        # Move fast pointer n + 1 steps ahead so slow stops one node before the target
        for _ in range(n + 1):
            fast = fast.next
            
        # Move both pointers until fast reaches the end
        while fast:
            slow = slow.next
            fast = fast.next
            
        # Remove the nth node
        slow.next = slow.next.next
        
        return dummy.next

if __name__ == "__main__":
    solution = RemoveNthNodeFromEndOfList()
    
    # Test Case 1
    head1 = build_linked_list([1, 2, 3, 4, 5])
    n1 = 2
    print(f"Input: {print_linked_list(head1)}, n={n1}")
    res1 = solution.removeNthFromEnd(head1, n1)
    print(f"Output: {print_linked_list(res1)}") # Expected: [1, 2, 3, 5]
    print("-" * 20)

    # Test Case 2: Remove head
    head2 = build_linked_list([1])
    n2 = 1
    print(f"Input: {print_linked_list(head2)}, n={n2}")
    res2 = solution.removeNthFromEnd(head2, n2)
    print(f"Output: {print_linked_list(res2)}") # Expected: []
    print("-" * 20)
    
    # Test Case 3: Remove last node
    head3 = build_linked_list([1, 2])
    n3 = 1
    print(f"Input: {print_linked_list(head3)}, n={n3}")
    res3 = solution.removeNthFromEnd(head3, n3)
    print(f"Output: {print_linked_list(res3)}") # Expected: [1]
