package com.naresh.old.javapractice.mt.exam;

	class Test1 {
		public static void main(String[] args) {
			Painter painter1 = new Painter();
			painter1.start();
			Painter painter2 = new Painter();
			painter2.start();
		}
	}

	 public class Painter implements Runnable {
		public void run() {
			System.out.println("we are painting");
		}
}

	 //comiletime error