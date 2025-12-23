package com.naresh.old.javapractice.mt.define.constr;

class MyThread  extends Thread implements Runnable  {
	public void run(){
		
		System.out.println("Child Thread");
		
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		MyThread t=new MyThread();
		Thread t1=new Thread(t);
		t1.start();
		System.out.println("In ThreadDemo:Main Thread");
		

	}

}
