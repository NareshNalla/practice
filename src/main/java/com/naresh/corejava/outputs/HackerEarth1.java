package com.naresh.corejava.outputs;

public class HackerEarth1 {

	public static void main(String[] args) {
		Language1 p = new Language1();
		p.name = "Ejava";
		func1(p);
		System.out.println(p.name);
		func2(p);
		System.out.println(p.name);
	}

	private static void func2(Language1 p) {
		p.name = "Python";
		System.out.println(p.name);
	}

	private static void func1(Language1 p) {
		p = new Language1();
		p.name = "Angular";
		System.out.println(p.name);
	}
}
class Language1{
	public String name;
}
