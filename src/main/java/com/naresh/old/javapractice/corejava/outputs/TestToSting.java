package com.naresh.old.javapractice.corejava.outputs;

public class TestToSting {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = new String(s1);
		String s3 = "HELLO";
		
		System.out.format("%b %b %b",
				(s1.equals(s2)),
				(s2.equals(s3)),(s1 == s2));
	}
	

}
