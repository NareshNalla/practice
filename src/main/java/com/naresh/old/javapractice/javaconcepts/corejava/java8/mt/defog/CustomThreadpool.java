package com.naresh.old.javapractice.javaconcepts.corejava.java8.mt.defog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomThreadpool {
	private static int cores= Runtime.getRuntime().availableProcessors();
	private static ExecutorService threadPool = Executors.newFixedThreadPool(cores);
	
	private static ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(()-> new SimpleDateFormat("dd/MM/yyyy"));
	public static void main(String[] args) {
		System.out.println(cores+" processors");
		for(int i=0; i< 10;i++) {
			int id =i;
			//submit
			threadPool.execute(()->{
			String dob = new CustomThreadpool().getDob(id);
			System.out.println(dob);
			});
			
		}
	}

	private String getDob(int i) {
		Date d = new Date();
		final SimpleDateFormat sd = ThreadSafeFormater.sdf.get();
		return sd.format(d);
	}

}
