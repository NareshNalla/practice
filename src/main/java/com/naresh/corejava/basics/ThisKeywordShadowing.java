package com.naresh.corejava.basics;

public class ThisKeywordShadowing {
	private int myValue = 0;

	public void showOne(int myValue) {
		myValue = myValue;
	}

	public void showTwo(int myValue) {
		this.myValue = myValue;
	}

	public static void main(String[] args) {
		ThisKeywordShadowing ct = new ThisKeywordShadowing();
		ct.showTwo(200);
		System.out.println(ct.myValue);
		ct.showOne(100);
		System.out.println(ct.myValue);
	}
}