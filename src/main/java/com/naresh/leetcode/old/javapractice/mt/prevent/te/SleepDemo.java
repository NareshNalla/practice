package com.naresh.leetcode.old.javapractice.mt.prevent.te;
/*
sleep(): This method causes the currently executing thread to sleep for the
specified number of milliseconds, 
subject to the precision and accuracy of system timers and schedulers*/

class MyThread2 extends Thread{
	public void run(){
		try{
			System.out.println("child");
			Thread.sleep(1000);
		}catch(InterruptedException ie){}
		
	}
	
}
public class SleepDemo {
	public static void main(String[] args)throws InterruptedException{
        MyThread2 t=new MyThread2();
		t.start();
		System.out.println("NARESH");
		Thread.sleep(2000);
		System.out.println("sathish");
		Thread.sleep(2000);
		System.out.println("suresh");
		Thread.sleep(2000);

	}

}
