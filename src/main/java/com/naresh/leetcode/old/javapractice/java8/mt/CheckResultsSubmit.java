package com.naresh.leetcode.old.javapractice.java8.mt;

import java.util.concurrent.*;

public class CheckResultsSubmit {
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> results = service.submit(() -> {
				for (int i = 0; i <100; i++)
					CheckResultsSubmit.counter++;
			});
			results.get(10, TimeUnit.SECONDS);
			System.out.println("Reached!");

		} catch (TimeoutException e) {
			System.out.println("Not reached in time");
		} finally {
			if (service != null)
				service.shutdown();
		}

	}
}