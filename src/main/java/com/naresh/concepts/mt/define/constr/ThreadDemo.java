package com.naresh.concepts.mt.define.constr;

class MyThread  extends Thread //implements Runnable
{
	public void run(){
		
		System.out.println("Child Thread");
		
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		MyThread t=new MyThread();
		Thread t1=new Thread(t);
		t1.start(); //t1.run() is first excecuting child run() then same flow
		System.out.println("In ThreadDemo:Main Thread");
		

	}

}
