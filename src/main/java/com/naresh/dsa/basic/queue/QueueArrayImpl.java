package com.naresh.dsa.basic.queue;

public class QueueArrayImpl<T> {
	Object[] ArrayQueue;
	int Rear;
	int Front;
	int size;
	public QueueArrayImpl(int size){
		this.size = size;
		ArrayQueue = new Object[this.size];
		Front = -1;
		Rear = -1;
	}
    public Boolean isFull(){
    	return (Rear == size-1);
    }
    public Boolean isEmpty(){
    	return (Rear == -1 || Front > Rear);
    }
    public void queue(Object newItem){
    	if(isFull()){
    		System.out.println("Queue is full");
    		return;
    	}
    	Rear = Rear +1;
    	ArrayQueue[Rear] = newItem;
    	if(Front == -1){
    		Front = 0;
    	}
    }
    public T deQueue(){
    	if(isEmpty()){
    		System.out.println("Queue is Empty");
    		return null;
    	}
    	T ObejctOut = (T) ArrayQueue[Front];
    	Front = Front + 1;
    	return ObejctOut;
    	
    }

}
