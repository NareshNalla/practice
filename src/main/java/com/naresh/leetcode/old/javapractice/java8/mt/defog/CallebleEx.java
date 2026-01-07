package com.naresh.leetcode.old.javapractice.java8.mt.defog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallebleEx {
	private static ExecutorService threadPool = Executors.newFixedThreadPool(4);

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		List<Future> allFutures = new ArrayList<>();
		
		Future<Integer> future = threadPool.submit(new Test());
		//Integer res = future.get();
		Integer res = future.get(1,TimeUnit.SECONDS);
		System.out.println(res+" int - current "+Thread.currentThread().getName());
		
		//methods
		future.isCancelled();
		future.isDone();
	}

}

class Test implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		return new Random().nextInt();
	}

}
