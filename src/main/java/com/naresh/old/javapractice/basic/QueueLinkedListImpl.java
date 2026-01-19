package com.naresh.old.javapractice.basic;

public class QueueLinkedListImpl<T> {
	NodeD Rear;
	NodeD Front;
	public QueueLinkedListImpl(){
		Rear = null;
		Front = null;
	}
	public void queue(Object value){
		NodeD newNode = new NodeD(value, null ,null);
		if(Rear == null){
			Rear = newNode;
			Front = newNode;
		}else{
			newNode.next = null;
			newNode.previous = Rear;
			Rear.next = newNode;
		}
	}
	public T deQueue(){
		if(Rear==null || Front==null){
			System.out.println("Queue is empty");
			return null;
		}
		T value =(T)Front.value;
		Front = Front.next;
		if(Front != null){
			Front.previous = null;}
		return value;
		
	}

}
