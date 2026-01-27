package com.naresh.leetcode.concepts.mt.exam;

class Swimmer1 implements Runnable {
	String name;
	Sysnc pool;

	Swimmer1(String name, Sysnc pool) {
		this.name = name;
		this.pool = pool;
	}

	public void run() {
		pool.swimIn(name);
	}
}

public class Sysnc {
	public void swimIn(String name) {
		synchronized(this) { //synchronized(this)
			System.out.println(name);
		}
		}

	public static void main(String[] args) {
		Sysnc pool = new Sysnc();
		new Thread(new Swimmer1("Tom", pool)).start();
		new Thread(new Swimmer1("Hanks", pool)).start();
	}
}