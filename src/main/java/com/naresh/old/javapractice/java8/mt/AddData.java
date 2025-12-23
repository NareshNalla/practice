package com.naresh.old.javapractice.java8.mt;

import java.util.concurrent.*;

public class AddData {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit(() -> 30 + 10);
			System.out.println(result.get());
		} finally {
			if (service != null)
				service.shutdown();
		}
		if (service != null) {
			service.awaitTermination(1, TimeUnit.MINUTES);
			// Check whether all tasks are finished
			if (service.isTerminated())
				System.out.println("All tasks finished");
			else
				System.out.println("At least one task is still running");
		}
	}
}