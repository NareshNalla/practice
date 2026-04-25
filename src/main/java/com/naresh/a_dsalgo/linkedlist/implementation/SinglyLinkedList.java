package com.naresh.a_dsalgo.linkedlist.implementation;

public class SinglyLinkedList<T> {
	NodeSLL head;
	public SinglyLinkedList(){
		head = null;
	}
	public void add(Object value){
		NodeSLL newNode= new NodeSLL(value,null);
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
		NodeSLL n=head;
		while(n != null){
			System.out.println((T)n.value);
			n = n.next;
		}
	}

}
