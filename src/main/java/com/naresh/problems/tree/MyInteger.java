package com.naresh.problems.tree;

public class MyInteger {
	private int count;
	
	public MyInteger(int count) {
		this.count = count;
	}
	public void set(int count) {
		this.count = count;
	}
	public void incr() {
		++count;
	}
	public void decr() {
		--count;
	}
	public int get() {
		return count;
	}
}