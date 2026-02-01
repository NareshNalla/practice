package com.naresh.dsalgo.hashing.implementation;

public class HashTableArrayTest {
	public static void main(String[] args) {
		HashTableArray<String> ht = new HashTableArray<String>(10);
		ht.put(11, "Naresh");
		ht.put(12, "Jashwanth");
		ht.put(13, "Hari Varan");
		ht.put(14, "Aravind");
		ht.put(14, "Raju");
		System.out.println(ht.get(11));
		System.out.println(ht.get(14));
	}
}
