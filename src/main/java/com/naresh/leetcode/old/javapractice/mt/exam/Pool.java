package com.naresh.leetcode.old.javapractice.mt.exam;

class Swimmer implements Runnable {
	String name;
	Pool pool;

	Swimmer(String name, Pool pool) {
		this.name = name;
		this.pool = pool;
	}

	public void run() {
		pool.swimIn(name);
	}
}

 public class Pool {
	public void swimIn(String name) {
		System.out.print(name);
		System.out.print(name);
	}

	public static void main(String[] args) {
		Pool pool = new Pool();
		new Thread(new Swimmer("Tom", pool)).start();
		new Thread(new Swimmer("Hanks", pool)).start();
	}
}
