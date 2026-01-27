package com.naresh.dsa.hash;

public class HashTableArrayTest {
	public static void main(String[] args) {
		HashTableArrayImpl<String> ht = new HashTableArrayImpl<String>(10);
		ht.put(11, "Naresh");
		ht.put(12, "Jashwanth");
		ht.put(13, "Hari Varan");
		ht.put(14, "Aravind");
		ht.put(14, "Raju");
		System.out.println(ht.get(11));
		System.out.println(ht.get(14));
	}
}
