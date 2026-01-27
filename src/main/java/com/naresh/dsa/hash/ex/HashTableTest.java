package com.naresh.dsa.hash.ex;
//Linear Probe Hash Table

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashTableTest {
	public static void main(String[] args) throws IOException {
		DataItem aDataItem;
		int aKey, size , n, keysPerCell;
		putText("Enter size of hash table:");
		size = getInt();
		putText("Enter initial number of itemse:");
		n = getInt();
		keysPerCell = 10;
		HashTableImpl theHashTable = new HashTableImpl(size);
		for(int j=0; j<n;j++){
			aKey = (int)(Math.random() * keysPerCell * size);
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aDataItem);
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
				theHashTable.insert(aDataItem);
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
	
	/*Linear Probing
	The following equations show the relationship between probe length (P) and load factor
	(L) for linear probing. For a successful search it's
	P = ( 1 + 1 / (1�L) 2 ) / 2
	and for an unsuccessful search it's
	P = ( 1 + 1 / (1�L) ) / 2
	*/
}
