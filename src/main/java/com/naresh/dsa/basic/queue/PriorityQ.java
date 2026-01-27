package com.naresh.dsa.basic.queue;

import java.io.IOException;

public class PriorityQ {
	private int maxSize;
	private double[] queueArray;
	private int nItems;
	public PriorityQ(int s){
		maxSize =s;
		queueArray = new double[maxSize];
		nItems = 0;
	}
	public void insert(double item){
		int j;
		if(nItems == 0){
			// If no items, insert at 0
			queueArray[nItems] = item;
			nItems++;
		}else{
			//start at end,
			for(j=nItems-1;j>=0;j--){
				//if new item, shift upward if smaller
				if( item > queueArray[j])
					queueArray[j+1] = queueArray[j];
				else
					break;
			}
			//insert 
			queueArray[j+1] = item; 
			nItems++;
		}
	}
	public double remove(){
		//removing minimum item
		return queueArray[--nItems];
	}
	public double PeekMin(){
		//Peek at minimum
		return queueArray[nItems-1];
	}
	public boolean isEmpty(){
		
		return (nItems ==0);
	}
	public boolean isFull(){
		return (nItems == maxSize);
	}
	//Test
	public static void main(String[] args) throws IOException{
		
		PriorityQ pq= new PriorityQ(5);
		pq.insert(30);
		pq.insert(40);
		pq.insert(10);
		pq.insert(20);
		pq.insert(50);
		
		while( !pq.isEmpty()){
			double item = pq.remove();
			System.out.println(item+" ");
		}
		System.out.println(" ");
			
		}
			
}
/*insertion runs in O(N) time, while
deletion takes O(1) time.*/
