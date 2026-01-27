package com.naresh.dsa.basic.stack;

public class StackArrayImpl<T> {
	Object[] ArrayStack;
	int size;
	int top;
	public StackArrayImpl(int size){
		this.size = size;
		ArrayStack = new Object[this.size];
		top =-1;
	}
	public Boolean isFull(){
		return (top == size-1);
	}
	public Boolean isEmpty(){
		return top == -1;
	}
	public void push(Object newItem){
		
		if(isFull()){
			System.out.println("Stack is full");
			return;
		}
		top = top + 1;
		ArrayStack[top] = newItem;
	}
	public T pop(){
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return null;
		}
		T item = (T)ArrayStack[top];
		top = top - 1;
		return item;
	}
	
	

}
