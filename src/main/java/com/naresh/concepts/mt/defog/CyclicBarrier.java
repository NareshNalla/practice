package com.naresh.concepts.mt.defog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrier {
	private static ExecutorService threadPool = Executors.newFixedThreadPool(4);
	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		
	    
		for(int i=0; i< 10;i++) {
			int id =i;
			threadPool.submit(()->{
			String dob = new CyclicBarrier().getDob(id);
			System.out.println(dob);
			});
			
		}
	}

	private String getDob(int i) {
		Date d = new Date();
		return df.format(d);
	}

}
