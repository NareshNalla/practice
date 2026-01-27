package com.naresh.concepts.mt.exam;
public class Thread1 {
	private static String msg = "HCL ";
	static{
		Thread t = new Thread(new Runnable(){
			public void run(){
				msg = "Technologies ";
				//System.out.println(msg);
			}
		});
		t.start();
	}
	public static void main(String[] args){
		
		System.out.print(msg);
	}}
//HCL