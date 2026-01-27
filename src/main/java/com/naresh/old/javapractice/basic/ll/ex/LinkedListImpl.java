package com.naresh.old.javapractice.basic.ll.ex;

public class LinkedListImpl<T> {
	NodeLL head;
	public LinkedListImpl(){
		head = null;
	}
	public void add(Object value){
		NodeLL newNode= new NodeLL(value,null);
		if(head == null){
			head=newNode;
		}else{
			newNode.next = head;
			head = newNode;
		}
	}
	public void delete(){
		head = head.next;
		
	}
	public void display(){
		NodeLL n=head;
		while(n != null){
			System.out.println((T)n.value);
			n = n.next;
		}
	}

}
