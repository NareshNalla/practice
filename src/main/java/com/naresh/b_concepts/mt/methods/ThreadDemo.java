package com.naresh.b_concepts.mt.methods;



class MyThread11 extends Thread{
	public void run(){
		System.out.println("Child");
		System.out.println(Thread.currentThread().getPriority());
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		MyThread11 t=new MyThread11();
		
		t.start();
		//t.setPriority(2);
		Thread.currentThread().setPriority(10);
		System.out.println(Thread.currentThread().getPriority());
		
	}

}
