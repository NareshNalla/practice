package com.naresh.dsa.basic.array;

public class DynamicArrayTest {
	public static void main(String[] args) {
		
		DynamicArrayImpl<Integer> da = new DynamicArrayImpl<Integer>();
		da.put(2);
		System.out.println("size:"+da.getSize());
		da.put(3);
		System.out.println("size:"+da.getSize());
		da.put(2);
		da.put(34);
		System.out.println("size:"+da.getSize());
		for (int i = 0; i < da.getSize(); i++) {
			System.out.println(da.get(i));			
			
		}
		
	}

}
