package com.naresh.leetcode.old.javapractice.basic;

import java.util.Arrays;

public class QueueDynamicArrayImpl<T> {
	Object[] ArrayQueue;
	int Rear;
	int Front;
	int size;
	public QueueDynamicArrayImpl(int size){
		this.size = size;
		ArrayQueue = new Object[this.size];
		Front = -1;
		Rear = -1;
	}
	/*never full */
    
    public Boolean isEmpty(){
    	return (Rear == -1 || Front > Rear);
    }
    public void queue(Object newItem){
    	ensureCapacity(Rear +2 );
    	
    	Rear = Rear +1;
    	ArrayQueue[Rear] = newItem;
    	if(Front == -1){
    		Front = 0;
    	}
    }
    public T deQueue(){
    	if(isEmpty()){
    		System.out.println("D Queue is Empty");
    		return null;
    	}
    	T ObejctOut = (T) ArrayQueue[Front];
    	Front = Front + 1;
    	return ObejctOut;
    	
    }
    public int getSize(){
    	return ArrayQueue.length;
    }
    public void ensureCapacity(int minCapacity){
		int oldCapacity = getSize();
		if(minCapacity > oldCapacity){
			int newCapacity = oldCapacity * 2;
			if(newCapacity < minCapacity){
				newCapacity = minCapacity;
			}
			ArrayQueue = Arrays.copyOf(ArrayQueue, newCapacity);
		}
	}
    
}
