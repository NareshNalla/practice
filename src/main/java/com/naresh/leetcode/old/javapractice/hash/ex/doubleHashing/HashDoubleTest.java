package com.naresh.leetcode.old.javapractice.hash.ex.doubleHashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashDoubleTest {
	public static void main(String[] args) throws IOException {
		DataItem aDataItem;
		int aKey, size , n;
		putText("Enter size of hash table:");
		size = getInt();
		putText("Enter initial number of itemse:");
		n = getInt();
		//keysPerCell = 10;
		HashTableImpl theHashTable = new HashTableImpl(size);
		for(int j=0; j<n;j++){
			//aKey = (int)(Math.random() * keysPerCell * size);
			aKey = (int)(Math.random() * 2 * size);
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aKey,aDataItem);
		}
		while(true){
			putText("Enter first letter of ");
			putText("show , insert , delete, or find :");
			char choice = getChar();
			switch(choice){
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				putText("Enter Key value to insert: ");
				aKey = getInt();
				aDataItem = new DataItem(aKey);
				theHashTable.insert(aKey, aDataItem);
				break;
			case 'd':
				putText("Enter key value to delete:");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;
				
			case 'f':
				putText("Enter key value to find:");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if(aDataItem != null){
					System.out.println("Found" + aKey);
				}else{
					System.out.println("Could not find"+aKey);
				}
				break;
				default:
					putText("Invalid entry\n");
			}
		}
		
	}

	private static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	private static int getInt() throws IOException {
		String s= getString();
		return Integer.parseInt(s);
	}

	private static String getString()throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		
		return s;
	}

	private static void putText(String string) {
		System.out.println(string);
		System.out.flush();
		
	}
	/*Table Size a Prime Number
	Double hashing requires that the size of the hash table is a prime number. To see why,
	imagine a situation where the table size is not a prime number. For example, suppose the
	array size is 15 (indices from 0 to 14), and that a particular key hashes to an initial index
	of 0 and a step size of 5. The probe sequence will be 0, 5, 10, 0, 5, 10, and so on,
	repeating endlessly. Only these three cells are ever examined, so the algorithm will never
	find the empty cells that might be waiting at 1, 2, 3, and so on. The algorithm will crash
	and burn.
	If the array size were 13, which is prime, the probe sequence eventually visits every cell.
	It's 0, 5, 10, 2, 7, 12, 4, 9, 1, 6, 11, 3, and so on and on. If there is even one empty cell,
	the probe will find it. Using a prime number as the array size makes it impossible for any
	number to divide it evenly, so the probe sequence will eventually check every cell.
	A similar effect occurs using the quadratic probe. In that case, however, the step size
	gets larger with each step, and will eventually overflow the variable holding it, thus
	preventing an endless loop.*/

	/*Separate Chaining
	no need to search for empty cells in the primary array.
	A data item's
	key is hashed to the index in the usual way, and the item is inserted into the linked list at
	that index.*/
	
	/*Quadratic Probing and Double Hashing
	Quadratic probing and double hashing share their performance equations. These indicate
	a modest superiority over linear probing. For a successful search, the formula (again from
	Knuth) is
	�log2(1�loadFactor) / loadFactor
	For an unsuccessful search it is
	1 / (1�loadFactor)*/
	
}
