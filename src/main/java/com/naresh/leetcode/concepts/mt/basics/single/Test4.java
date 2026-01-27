package com.naresh.leetcode.concepts.mt.basics.single;
class NewThread1 extends Thread{
	
	public void run(){
		try{
		for(int i=1;i<=10;i++){
			System.out.println("Child Thread"+i);
			Thread.sleep(2000);
		}System.out.println("child Terminated");
	}catch(InterruptedException ie){ System.out.println("Interupted");}
}
}
public class Test4 {
	public static void main(String[] args) throws  InterruptedException {
		NewThread1 t=new NewThread1();
		t.run();
		while(t.isAlive()){
			System.out.println("Main Thread");
			Thread.sleep(1000);
		}
		
		System.out.println("Main Therminated");
	}

}
