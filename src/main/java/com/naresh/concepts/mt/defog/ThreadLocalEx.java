package com.naresh.concepts.mt.defog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalEx {
	private static ExecutorService threadPool = Executors.newFixedThreadPool(4);
	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		//final CyclicBarrier cb = new CyclicBarrier(3,()-> S);
	    
	    List s = new ArrayList();
	    s.add(1);
	    s.add(5);
	    s.add(3);
	    Collections.sort(s);
	    s.add(2);
	    System.out.println(s);
	    
		for(int i=0; i< 1;i++) {
			int id =i;
			threadPool.submit(()->{
			String dob = new ThreadLocalEx().getDob(id);
			System.out.println(dob);
			});
			
		}
	}

	private String getDob(int i) {
		Date d = new Date();
		return df.format(d);
	}

}
