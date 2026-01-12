'''
https://leetcode.com/problems/reverse-linked-list/
Given the head of a singly linked list, reverse the list, and return the reversed list.
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
'''
from typing import Optional
from ListNode import ListNode
from LinkedListUtils import build_linked_list, print_linked_list

class ReverseLinkedList:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev, curr = None , head
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return prev

if __name__ == "__main__":
    # Input: head = [1,2,3,4,5]
    input_values = [1, 2, 3, 4, 5]
    head = build_linked_list(input_values)
    
    print(f"Original List: {print_linked_list(head)}")
    
    solution = ReverseLinkedList()
    reversed_head = solution.reverseList(head)
    
    # Output: [5,4,3,2,1]
    print(f"Reversed List: {print_linked_list(reversed_head)}")