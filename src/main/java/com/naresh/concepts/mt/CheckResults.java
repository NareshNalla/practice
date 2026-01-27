package com.naresh.concepts.mt;

public class CheckResults {
	private static int counter = 0;

	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 50; i++)
				CheckResults.counter++;
		}).start();
		
		while (CheckResults.counter < 10) {
			System.out.println("Not reached yet");
		}
		System.out.println("Reached!");
	}
}