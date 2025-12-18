package com.naresh.outputs.factset;

public class TestException {
public static void main(String[] args) {
	TestException t= new TestException();
	t.f();
}

private  void f() {
	
	synchronized ("") {//boolean not allowed
		try{
			//monitor.wait();
		}catch(Exception e){
			
		}
	}
}
}
