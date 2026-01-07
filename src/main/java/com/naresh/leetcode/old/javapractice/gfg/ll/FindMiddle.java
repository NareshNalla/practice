package com.naresh.leetcode.old.javapractice.gfg.ll;

public class FindMiddle {
	static Node head;
	public static void main(String[] args) {
		insert(1);
		insert(3);
		insert(6);
		insert(9);
		insert(11);
		insert(-2);
		
		print();
		
	int result=	findMiddle();
	System.out.println("Middle: "+result);
	
	int result1=	findMiddle2();
	System.out.println("Middle: "+result);
	
	}
	private static int findMiddle() {
		Node fptr= head;
		Node sptr = head;
		if (head != null){
		while(fptr != null && fptr.next != null){
			sptr = sptr.next;
			fptr = fptr.next.next;
		}
		}
		return sptr.value;
	}
	//2nd
	static int  findMiddle2()
	{
	    int count = 0;
	    Node mid = head;
	 
	    if (mid == null)
	    	return 0;
	    
	    while (head != null)
	    {
	        if (count%2 != 0 )
	            mid = mid.next;
	 
	        ++count;
	        head = head.next;
	    }
	    return mid.value;
	}
	
	private static void insert(int i) {
		Node newNode = new Node(i);
		if(head==null){
			head =newNode;
			return;
		}
		newNode.next = null;
		Node last = head;
		while(last.next != null){
			last = last.next;
		}
		last.next =newNode;
		return;		


	}
	static void print(){
		Node n= head;
		while(n!=null){
			System.out.println(" "+n.value);
			n = n.next;

		}

	}
	static class Node{
		Node next;
		int value;
		Node(int value){
			this.value = value;
			this.next = null;
		}

	}

}