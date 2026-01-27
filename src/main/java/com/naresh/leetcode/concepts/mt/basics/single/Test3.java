package com.naresh.leetcode.concepts.mt.basics.single;
class NewThread implements Runnable{
	public NewThread(){
		(new Thread(this)).start();
	}
	public void run(){
		try{
		for(int i=1;i<=2;i++){
			System.out.println("Child Thread"+i);
			Thread.sleep(2000);
		}System.out.println("child Terminated");
	}catch(InterruptedException ie){ System.out.println("Interupted");}
}
}
public class Test3 {
	public static void main(String[] args) throws  Exception {
		NewThread t=new NewThread();
		
		for(int i=1;i<=2;i++){
			t.run();
			System.out.println("Main Thread"+i);
			Thread.sleep(1000);
		}
		
		System.out.println("Main Therminated");
	}

}
