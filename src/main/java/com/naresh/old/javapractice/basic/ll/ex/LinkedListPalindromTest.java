package com.naresh.old.javapractice.basic.ll.ex;

public class LinkedListPalindromTest {
    static Node slow_ptr, fast_ptr, second_half;

    public static void main(String[] args) {
        Node head = null;
        char str[] = {'M', 'A', 'D', 'A', 'M'};
        
        for (int i = 0; i < str.length; i++) {
            head = LinkedListUtil.push(head, str[i]);
            LinkedListUtil.printList(head);
            
            if (isPalindrome(head)) {
                System.out.println("Is Palindrome");
                System.out.println("");
            } else {
                System.out.println("Not Palindrome");
                System.out.println("");
            }
        }
    }

    static boolean isPalindrome(Node head) {
        slow_ptr = head;
        fast_ptr = head;
        Node prev_of_slow_ptr = head;
        Node midnode = null;
        boolean result = true;

        if (head != null && head.next != null) {
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                prev_of_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
            if (fast_ptr != null) {
                midnode = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
            second_half = slow_ptr;
            prev_of_slow_ptr.next = null;
            reverse();
            result = compareLists(head, second_half);

            reverse(); // Restore the list

            if (midnode != null) {
                prev_of_slow_ptr.next = midnode;
                midnode.next = second_half;
            } else {
                prev_of_slow_ptr.next = second_half;
            }
        }

        return result;
    }

    static void reverse() {
        Node prev = null;
        Node current = second_half;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second_half = prev;
    }

    static boolean compareLists(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else
                return false;
        }
        if (temp1 == null && temp2 == null)
            return true;

        return false;
    }
}
