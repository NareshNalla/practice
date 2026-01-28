package com.naresh.dsa.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapTest {
	public static void main(String[] args) throws IOException {
		int value, value2;
		MinHeap theHeap = new MinHeap(31);
		boolean success;
		theHeap.insert(70);
		theHeap.insert(40);
		theHeap.insert(50);
		theHeap.insert(20);
		theHeap.insert(60);
		theHeap.insert(100);
		theHeap.insert(80);
		theHeap.insert(30);
		theHeap.insert(10);
		theHeap.insert(90);
		while(true){
			putText(" \n Enter first letter of ");
			putText("show, insert, remove, change: ");
			int choice = getChar();
			switch(choice){
			case 's': // shows
				theHeap.displayHeap();
				break;
			case 'i': // insert
				putText("Enter value to insert: ");
				value = getInt();
				success = theHeap.insert(value);
				if( !success )
				putText("Can't insert; heap is full" + '\n');
				break;
			case 'r': // remove
				if( !theHeap.isEmpty() )
				theHeap.remove();
				else
				putText("Can't remove; heap is empty" +	'\n');
				break;
			case 'c': // change
				putText("Enter index of item: ");
				value = getInt();
				putText("Enter new priority: ");
				value2 = getInt();
				success = theHeap.change(value, value2);
				if( !success )
				putText("Can't change; invalid index" +'\n');
				break;
			default:
				putText("Invalid entry\n");
				}
				
			}
			
		}
		

	private static int getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}


	private static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

	private static void putText(String string) {
		System.out.print(string);
		System.out.flush();
		
	}

}
/*
A heap is a special kind of binary tree, and as we saw in Chapter 8, the number of levels L
in a binary tree equals log2(N+1), where N is the number of nodes. The trickleUp() and
trickleDown() routines cycle through their loops L1 times, so the first takes time
proportional to log2N, and the second somewhat more because of the extra comparison.
Thus the heap operations we've talked about here all operate in O(logN) time.*/