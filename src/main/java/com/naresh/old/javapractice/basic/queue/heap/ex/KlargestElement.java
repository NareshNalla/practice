package com.naresh.old.javapractice.basic.queue.heap.ex;

import java.util.PriorityQueue;

public class KlargestElement {
	
	public static void printKLargestElement(int arr[] , int k){
		PriorityQueue  heap = new PriorityQueue<>();
		for(int i=0; i<k;++i){
			heap.add(arr[i]);
		}
		for(int i=k;i < arr.length; ++i){
			if(arr[i] < (int)heap.peek()){
				heap.poll();
				heap.add(arr[i]);
			}
		}
		while( !heap.isEmpty()){
			System.out.println(heap.poll());
		}
	}
	public static void main(String[] args) {
		int ropes[] = {4, 3, 2, 6,13,9};
		
		printKLargestElement(ropes,5);
		
	}
}
