package com.naresh.a_concepts.mt;

public class ReadInventoryThread extends Thread {
	public void run() {
		System.out.println("Printing zoo inventory");
	}

	public static void main(String[] args) {
		(new ReadInventoryThread()).start();
	}
}