package com.naresh.old.javapractice.corejava.outputs;

public class Test10 {
	void probe(Object x) { System.out.println("In Object"); } //3 

	void probe(Number x) { System.out.println("In Number"); } //2

	void probe(Integer x) { System.out.println("In Integer"); } //2

	void probe(Long x) { System.out.println("In Long"); } //4
	void probe(String x) { System.out.println("In String"); } //5

	public static void main(String[] args){
		//double a = 10.0; 
		String a = "10"; 
		new Test10().probe(a); 
	}
}