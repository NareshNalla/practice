package com.naresh.old.javapractice.mt.prevent.te;
class MyThread1 extends Thread{
	public void run(){
	
		for(int i=0;i<10;i++){
			System.out.println("seetha"+i);
			try{
				Thread.sleep(2000);
			} catch(InterruptedException ie){
							}
		}
	}
}

public class JoinDemo {
	public static void main(String[] args)throws InterruptedException {
		MyThread1 t=new MyThread1();
		MyThread1 t1=new MyThread1();
		t.start();
		//t.join(); //then it will print other wise.. first rama then seetha.
		t.join(1500);  
		for(int i=0;i<10;i++){
			System.out.println("Rama"+i);
	    }
		//t1.start();
   }
}