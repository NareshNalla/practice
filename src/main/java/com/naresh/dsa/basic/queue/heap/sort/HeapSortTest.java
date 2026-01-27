package com.naresh.dsa.basic.queue.heap.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSortTest {
	public static void main(String[] args) throws IOException{
		int size, j;
		System.out.print("Enter number of items: ");
		size = getInt();
		HeapSortImpl theHeap = new HeapSortImpl(size);
		for(j=0; j<size; j++) // fill array with
		{ // random nodes
			int random = (int)(Math.random()*100);
			Node newNode = new Node(random);
			theHeap.insertAt(j, newNode);
			theHeap.incrementSize();
		}
		System.out.print("Random: ");
		theHeap.displayArray(); // display random array
		for(j=size/2-1; j>=0; j--) // make random array intoheap
			theHeap.trickleDown(j);
		System.out.print("Heap: ");
		theHeap.displayArray(); // dislay heap array
		theHeap.displayHeap(); // display heap
		for(j=size-1; j>=0; j--) // remove from heap and
		{ // store at array end
			Node biggestNode = theHeap.remove();
			theHeap.insertAt(j, biggestNode);
		}
		System.out.print("Sorted: ");
		theHeap.displayArray(); // display sorted array
	} // end main()	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
}
/*
As we noted, heapsort runs in O(N*logN) time. Although it may be slightly slower than
quicksort, an advantage over quicksort is that it is less sensitive to the initial distribution of
data. Certain arrangements of key values can reduce quicksort to slow O(N2) time,
whereas heapsort runs in O(N*logN) time no matter how the data is distributed*/