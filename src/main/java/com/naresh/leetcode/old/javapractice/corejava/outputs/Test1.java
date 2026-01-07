package com.naresh.leetcode.old.javapractice.corejava.outputs;

public class Test1 {
	public static void main(String[] args) {
		System.out.println(Boolean.parseBoolean("true"));
		System.out.println(new Boolean(null));
		//System.out.println(new Integer());
		//no wrapper containes default constructor
		System.out.println(new Boolean("true"));
		System.out.println(new Boolean("trUE"));
	}

}
