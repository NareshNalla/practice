package com.naresh.dsa.stack;

public class StackArrayTest {
	public static void main(String[] args) {
		StackArray< Integer> sa= new StackArray<Integer>(3);
		sa.push(10);
		sa.push(11);
		sa.push(12);
		sa.push(14);
		while(!sa.isEmpty()){
			System.out.println(sa.pop());
		}
		sa.pop();
	}
}
