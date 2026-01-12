'''
https://leetcode.com/problems/merge-two-sorted-lists/
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
'''
from typing import Optional
from ListNode import ListNode
from LinkedListUtils import build_linked_list, print_linked_list

class MergeTwoSortedLists:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        # Dummy node to simplify the head logic
        dummy = ListNode(-1)
        tail = dummy
        # Iterate while both lists have nodes
        while list1 and list2:
            if list1.val <= list2.val:
                tail.next = list1
                list1 = list1.next
            else:
                tail.next = list2
                list2 = list2.next
            tail = tail.next
        # Attach the remaining part of the list that is not empty
        if list1:
            tail.next = list1
        if list2:
            tail.next = list2
            
        return dummy.next

if __name__ == "__main__":
    solution = MergeTwoSortedLists()
    
    # Test Case 1
    l1 = build_linked_list([1, 2, 4])
    l2 = build_linked_list([1, 3, 4])
    merged = solution.mergeTwoLists(l1, l2)
    print(f"Merged List: {print_linked_list(merged)}") # Expected: [1, 1, 2, 3, 4, 4]
    
    # Test Case 2: Empty lists
    l1 = build_linked_list([])
    l2 = build_linked_list([])
    merged = solution.mergeTwoLists(l1, l2)
    print(f"Merged Empty Lists: {print_linked_list(merged)}") # Expected: []
    
    # Test Case 3: One empty list
    l1 = build_linked_list([])
    l2 = build_linked_list([0])
    merged = solution.mergeTwoLists(l1, l2)
    print(f"Merged One Empty: {print_linked_list(merged)}") # Expected: [0]
