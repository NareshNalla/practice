package com.naresh.leetcode.old.javapractice.gfg.ll;

public class DeleteLinkedList {
	 // A complete working Java program to demonstrate deletion in singly
	// linked list
	static  Node head; // head of list
	 
	    /* Linked list Node*/
	    class Node
	    {
	        int data;
	        Node next;
	        Node(int d)
	        {
	            data = d;
	            next = null;
	        }
			public void next(Node next2) {
				// TODO Auto-generated method stub
				
			}
	    }
	 
	    /* Given a key, deletes the first occurrence of key in linked list */
	    void deleteNode(int key){
	        // Store head node
	        Node temp = head, prev = null;
	 
	        // If head node itself holds the key to be deleted
	        if (temp != null && temp.data == key){
	            head = temp.next; // Changed head
	            return;
	        }
	 
	        // Search for the key to be deleted, keep track of the
	        // previous node as we need to change temp.next
	        while (temp != null && temp.data != key){
	            prev = temp;
	            temp = temp.next;
	        }    
	 
	        // If key was not present in linked list
	        if (temp == null) return;
	 
	        // Unlink the node from linked list
	        prev.next = temp.next;
	    }
	 
	    /* Inserts a new Node at front of the list. */
	    public void push(int new_data)
	    {
	        Node new_node = new Node(new_data);
	        new_node.next = head;
	        head = new_node;
	    }
	 
	    /* This function prints contents of linked list starting from
	        the given node */
	    public void printList()
	    {
	        Node tnode = head;
	        while (tnode != null)
	        {
	            System.out.print(tnode.data+" ");
	            tnode = tnode.next;
	        }
	    }
	 
	    /* Drier program to test above functions. Ideally this function
	    should be in a separate user class. It is kept here to keep
	    code compact */
	    public static void main(String[] args)
	    {
	    	DeleteLinkedList llist = new DeleteLinkedList();
	 
	        llist.push(7);
	        llist.push(1);
	        llist.push(3);
	        llist.push(2);
	 
	        System.out.println("\nCreated Linked list is:");
	        llist.printList();
	 
	        //llist.deleteNode(1); // Delete node at position 4
	      //  removeNodeFromKey(2);
	        deleteNodeKey(1);
	        System.out.println("\nLinked List after Deletion at position :");
	        llist.printList();
	    }
	    
	    public static void removeNodeFromKey(int key){
	    	Node temp = head;
	    	// If key is present at first position
	    	if(temp !=null && temp.data == key){
	    	head = temp.next;
	    	return;
	    	}
	    	while (temp.next!=null && temp.next.data != key){
	    	temp = temp.next;
	    	}
	    	/* If key is not present and pointer reaches last node to avoid null pointer exception for temp.getNext().getNext(); */
	    	if(temp.next!=null) {
	    	temp.next = temp.next.next;

	    	}else {
	    	System.out.println( "The key "+ key +" is not present in linked list");
	    	}
	    	}
	    /* Given a reference (pointer to pointer) to the head of a list
	       and a position, deletes the node at the given position */
	  public static  void deleteNodeKey(int position)
	    {
	        // If linked list is empty
	        if (head == null)
	            return;
	        // Store head node
	        Node temp = head;
	        // If head needs to be removed
	        if (position == 0){
	            head = temp.next;   // Change head
	            return;
	        }
	        // Find previous node of the node to be deleted
	        for (int i=0; temp!=null && i<position-1; i++)
	            temp = temp.next;
	        // If position is more than number of ndoes
	        if (temp == null || temp.next == null)
	            return;
	        // Node temp->next is the node to be deleted
	        // Store pointer to the next of node to be deleted
	        Node next = temp.next.next;
	        temp.next = next;  // Unlink the deleted node from list
	    }
	 
	    
	    
	}