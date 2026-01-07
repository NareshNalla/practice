package com.naresh.leetcode.old.javapractice.java8.mt.defog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class ThreadLocalEx3 {
	private static int cores= Runtime.getRuntime().availableProcessors();
	private static ExecutorService threadPool = new ThreadPoolExecutor(cores, 100, 120, TimeUnit.SECONDS, new ArrayBlockingQueue<>(300));
	
	private static ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(()-> new SimpleDateFormat("dd/MM/yyyy"));
	public static void main(String[] args) {
		System.out.println(cores+" processors - "+threadPool.isShutdown());
		for(int i=0; i< 10;i++) {
			int id =i;
			//submit
			try {
			threadPool.execute(()->{
			String dob = new ThreadLocalEx3().getDob(id);
			System.out.println(dob);
			});
			}catch (RejectedExecutionException e) {
				// TODO: handle exception
			}
			
		}
		threadPool.shutdown();
	}

	private String getDob(int i) {
		Date d = new Date();
		final SimpleDateFormat sd = ThreadSafeFormater.sdf.get();
		return sd.format(d);
	}

}
