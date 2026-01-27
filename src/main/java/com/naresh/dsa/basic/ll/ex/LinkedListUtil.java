package com.naresh.dsa.basic.ll.ex;

public class LinkedListUtil {

    public static Node push(Node head, char new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
        return head;
    }

    public static void printList(Node ptr) {
        while (ptr != null) {
            System.out.print(ptr.data + "->");
            ptr = ptr.next;
        }
        System.out.println("NULL");
    }
}
