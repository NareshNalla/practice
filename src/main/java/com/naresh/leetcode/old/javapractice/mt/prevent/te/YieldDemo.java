package com.naresh.leetcode.old.javapractice.mt.prevent.te;

/*
 * yield() basically means that the thread is not doing anything particularly important 
 * and if any other threads or processes need to be run, they should run. Otherwise, 
 * the current thread will continue to run.
*/

class MyThread extends Thread{
	public void run(){
		
		for(int i=0;i<10;i++){
			 if ((i % 5) == 0) {
			  // yields control to another thread every 5 iterations
			Thread.yield();
		System.out.println("child"+i);
		}
		}
		/*causes the currently executing thread object to temporarily 
        pause and allow other threads to execute 
	*/
	}
}
public class YieldDemo {
	public static void main(String[] args) {
	MyThread t=new MyThread();
	t.start();
	for(int i=0;i<10;i++){
	System.out.println("main"+i);
	}
	
	}

}
