package com.naresh.dsa.basic.ll.ex;


public class DoubleLinkedListI<T> {
	NodeD head;
	public DoubleLinkedListI(){
		head = null;
	}
	public void add(Object value){
		NodeD newNode = new NodeD(value, null,null);
		if(head == null){
			head = newNode;
		}else{
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
	}
	public void delete(){
		head = head.next;
		head.previous = null;
	}
	public void diplay(){
		NodeD n=head;
		while(n != null){
			System.out.println((T)n.value);
			n=n.next;
		}
	}
}
