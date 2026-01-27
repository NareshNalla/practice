package com.naresh.corejava.basics;

public class ObjectEqualityCheck {
    public static void main(String[] args) {

	Object obj1 = new Object();
	Object obj2 = new Object();

	if (obj1.equals(obj2)) {
	    System.out.println("hello");
	}
	if (obj1 == obj2) {
	    System.out.println("hi");
	}

    }

}
