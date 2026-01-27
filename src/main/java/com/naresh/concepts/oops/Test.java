package com.naresh.concepts.oops;

import java.io.IOException;

class A {
	void m1() throws IOException {
		System.out.println("A m1");
	}
}

class B extends A {
	public void m1() {{//not an issue
		System.out.println("B m1");
	}}
}

public class Test {
	public static void main(String[] args) throws IOException /*throws IOException*/ {
		A a = new B();
		a.m1();
	}
}