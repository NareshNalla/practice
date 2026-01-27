package com.naresh.concepts.mt.defog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalEx2 extends ThreadLocalEx {
    static int a=4;
    public static class Innter{
	static int b=3;
	public static void sum() {
	    System.out.println(a+b);
	}
    }
	private static ExecutorService threadPool = Executors.newFixedThreadPool(4);
	
	public static void main(String[] args) {
		
		for(int i=0; i< 10;i++) {
			int id =i;
			threadPool.submit(()->{
			String dob = new ThreadLocalEx2().getDob(id);
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
class ThreadSafeFormater{
	
	public static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("dd/MM/yyyy");
		}
		@Override
		public SimpleDateFormat get() {
			return super.get();
		}
	};
	
}
