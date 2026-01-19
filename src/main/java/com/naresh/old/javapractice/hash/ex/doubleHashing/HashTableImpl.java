package com.naresh.old.javapractice.hash.ex.doubleHashing;

public class HashTableImpl {
	DataItem[] hashArray;
	int arraySize;
	DataItem nonItem;
	public HashTableImpl(int size){
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}
	public void displayTable(){
		System.out.println("Table: ");
		for(int j=0; j<arraySize; j++){
			if(hashArray[j] != null){
				System.out.println(hashArray[j].iData +" ");
			}else
				System.out.println("** ");
		}
		System.out.println("");
	}
	public int hashFunc1(int key){
		return key % arraySize;
	}
	public int hashFunc2(int key){
		return 5 - key % 5; //must prime
	}
	
	public void insert(int key, DataItem aDataItem){
		int hashVal = hashFunc1(key);
		int stepSize = hashFunc2(key);
		while(hashArray[hashVal] !=null && hashArray[hashVal].iData !=-1){
			//++hashVal;
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		hashArray[hashVal] = aDataItem;
	}
	public DataItem delete(int key){
		int hashVal = hashFunc1(key);
		int stepSize = hashFunc2(key);
		while(hashArray[hashVal] !=null){
			if(hashArray[hashVal].iData == key){
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}
			//++hashVal;
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		return null;
	}
	public DataItem find(int key){
		int hashVal =hashFunc1(key);
		int stepSize = hashFunc2(key);
				
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].iData == key)
				return hashArray[hashVal];
			//++hashVal;
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		return null;
	}

}
