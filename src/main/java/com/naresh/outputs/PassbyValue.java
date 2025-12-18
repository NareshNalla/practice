package com.naresh.outputs;

public class PassbyValue {
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

/*
observe variable name is same reference changing. method level are local no changes.

Java is always pass-by-value. For objects, this means a copy of the reference is passed. You can change the state of the object the reference points to, but if you reassign the reference itself (like obj = ...), it only affects the local copy.
        •
Wrapper classes like Integer are immutable. Operations like obj++ don't change the existing Integer object; they create a new Integer object.
        •
Be very careful with pre-increment (++i) vs. post-increment (i++), especially when they are used as method arguments.
*/