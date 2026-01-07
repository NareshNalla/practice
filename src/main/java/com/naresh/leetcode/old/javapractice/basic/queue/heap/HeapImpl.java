package com.naresh.leetcode.old.javapractice.basic.queue.heap;

public class HeapImpl {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;
	public HeapImpl(int mx){
		maxSize = mx;
		currentSize= 0;
		heapArray= new Node[maxSize];
	}
	public boolean isEmpty(){
		return (currentSize == 0);
	}
	public boolean insert(int key){
		//if array is full failure
		if(currentSize == maxSize){
			return false;
		}
		//make a new node put it at the end, trickle it up
		Node newNode = new Node(key); 
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}
	public void trickleUp(int index) {
		int parent = (index-1) /2;
		Node bottom = heapArray[index];
		while((index >0) && (heapArray[parent].iData < bottom.iData) ){
		//move node to down , move index up , parent <- its parent	
		heapArray[index] = heapArray[parent];
		index = parent;
		parent = (parent - 1) /2;
		}
		heapArray[index] = bottom;
	}
	public Node remove(){
		//delete item with max key (assume non-empty list),
		//save the root root <- last , trckle down the root , return removed node.
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}
	public void trickleDown(int index) {
		// save root, while node has at least one child, find larger child
		//(rightChild exists?) , top .= largerChild? , shift child up , go down. index <- root
		int largerChild;
		Node top = heapArray[index];
		while( index < currentSize /2){
			int leftChild = 2*index+1;
			int rightChild = leftChild+1;
			if(rightChild < currentSize && heapArray[leftChild].iData < heapArray[rightChild].iData){
				largerChild = rightChild;
			}else{
				largerChild = leftChild;
			}
			if(top.iData >= heapArray[largerChild].iData)
				break;
			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}
		heapArray[index] = top;
	}
	public boolean change(int index, int newValue){
//remember old, change to new , if raised, trickle it up, if lowered, trickle it down.
		if(index<0 || index >= currentSize)
			return false;
		int oldValue = heapArray[index].iData;
		heapArray[index].iData = newValue;
		if(oldValue < newValue)
			trickleUp(index);
		else
			trickleDown(index);
		return true;
	}
	
	public void displayHeap(){
		System.out.print("heapArray: ");
		for(int m=0; m<currentSize; m++){
			if(heapArray[m] != null)
				System.out.print( heapArray[m].iData + " ");
			else
				System.out.print( "-- ");
		}
		
		System.out.println();
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		String dots = "...............................";
		System.out.println(dots+dots);
		while(currentSize > 0){
			if(column == 0)
				for(int k=0; k<nBlanks; k++)
					System.out.print(' ');
			System.out.print(heapArray[j].iData);
			if(++j == currentSize)
				break;
			if(++column==itemsPerRow){
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			}else{
				for(int k=0; k<nBlanks*2-2; k++)
					System.out.print(' ');
			}
			
		}	
	}
	
}
