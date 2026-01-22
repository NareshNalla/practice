package com.naresh.old.javapractice.javaconcepts.corejava.oops;

public class OverloadingTest {
	public int add(int a, int b) {

		int sum = a + b;
		return sum;
	}

	public long add(long a, long b) {

		long sum = a + b;
		return sum;
	}
	public static void main(String[] args) {

		OverloadingTest ob = new OverloadingTest();

		long l = ob.add(1, 2);
		System.out.println("sum of the two integer value :" + l);

	}
	//no matter what .. lint method will call
}