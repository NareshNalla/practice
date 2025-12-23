package com.naresh.old.javapractice.companywise.factset;

public class TestException {
public static void main(String[] args) {
	TestException t= new TestException();
	t.f();
}

private  void f() {
	
	synchronized (true) {
		try{
			monitor.wait();
		}catch(Exception e){
			
		}
	}
}
}
