package com.naresh.old.javapractice.corejava.generics;

import java.util.List;

class A {}

class B extends A{}

class C extends B{}

public class Test6 {

	public List<? extends B> ring1(){
		return null;

		// line 1		

	}

}