package com.naresh.outputs.factset;

public class StringTest {
	public static void main(String[] args) {
		String a = "a";
		//String a = new String("a");
		String b = "a";
		String c = a;
		
		System.out.format("%b %b %b %b",
				(a == b),
				(a.equals(b)),
				(a == c),
				(a.equals(c)));
	}

}
