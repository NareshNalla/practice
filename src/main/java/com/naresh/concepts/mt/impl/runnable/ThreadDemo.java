package com.naresh.concepts.mt.impl.runnable;
class MyThread implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
		System.out.println("Child Thread"+i);
		}
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		MyThread t=new MyThread();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
	
		
		t1.start(); //new thread
		t2.start(); //new
		//t1.run(); //no new 
		//t2.run();//no new
		//t.start(); //CE :excepn
		//t.run(); //no new 
		for(int i=0;i<10;i++){
			System.out.println("Main Thread"+i);
		}

	}

}
