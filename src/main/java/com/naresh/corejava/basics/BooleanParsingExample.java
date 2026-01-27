package com.naresh.corejava.basics;

public class BooleanParsingExample {
	public static void main(String[] args) {
		System.out.println(Boolean.parseBoolean("true"));
		System.out.println(new Boolean(null));
		//System.out.println(new Integer());
		//no wrapper containes default constructor
		System.out.println(new Boolean("true"));
		System.out.println(new Boolean("trUE"));
	}

}
