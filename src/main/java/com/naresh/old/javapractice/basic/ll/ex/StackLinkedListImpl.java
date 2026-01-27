package com.naresh.old.javapractice.basic.ll.ex;

public class StackLinkedListImpl<T> {

	NodeLL top;
	public StackLinkedListImpl(){
		top = null;
	}
	public void push(Object value){
		NodeLL newNode= new NodeLL(value, null);
		if(top == null){
			top = newNode;
		}else{
			newNode.next = top;
			top = newNode;
		}
	}
	public T pop(){
		if(top == null){
			System.out.println("Stack is empty");
			return null;
		}
		T value = (T) top.value;
		top = top.next;
		return value;
	}
}
