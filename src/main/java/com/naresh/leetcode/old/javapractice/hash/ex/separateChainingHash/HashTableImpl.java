package com.naresh.leetcode.old.javapractice.hash.ex.separateChainingHash;

public class HashTableImpl {
	private SortedListImpl[] hashArray;
	private int arraySize;
	
	public HashTableImpl(int size){
		arraySize = size;
		hashArray = new SortedListImpl[arraySize];
		for(int j=0; j<arraySize;j++)
		hashArray[j] = new SortedListImpl();
	}
	public void displayTable(){
		System.out.println("Table: ");
		for(int j=0; j<arraySize; j++){
				System.out.println(j +". ");
				hashArray[j].displayList();
				
		}
		System.out.println("");
	}
	public int hashFunc(int key){
		return key % arraySize;
	}
	public void insert(Link theLink){
		int key = theLink.iData;
		int hashVal = hashFunc(key);
		
		hashArray[hashVal].insert(theLink);
	}
	public void delete(int key){
		int hashVal = hashFunc(key);
		hashArray[hashVal].delete(key);
	}
	public Link find(int key){
		int hashVal =hashFunc(key);
		Link theLink = hashArray[hashVal].find(key);
		return theLink;
	}
	
}
