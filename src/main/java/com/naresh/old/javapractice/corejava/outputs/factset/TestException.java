package com.naresh.old.javapractice.corejava.outputs.factset;

public class TestException {
public static void main(String[] args) {
	TestException t= new TestException();
	t.f();
}

private  void f() {
	
	synchronized (true) {//boolean not allowed
		try{
			//monitor.wait();
		}catch(Exception e){
			
		}
	}
}
}
