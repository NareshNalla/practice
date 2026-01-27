package com.naresh.corejava.basics;

public class IntegerReferenceExample {
	public static void testInts(Integer obj, int var){ 
		obj = var++;        
		obj++;   
	}    
	public static void main(String[] args) {       
		Integer val1 = new Integer(5);     
		int val2 = 9;   
		testInts(val1++, ++val2);
		System.out.println(val1+" "+val2);   
	}
}

//observe variable name is same reference changing. method level are local no changes.