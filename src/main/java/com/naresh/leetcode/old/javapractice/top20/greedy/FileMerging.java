package com.naresh.leetcode.old.javapractice.top20.greedy;

import java.util.PriorityQueue;

public class FileMerging {

	public static int getMergeCost(int[] files) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < files.length; ++i) {
			pq.add(files[i]);
		}
		int totCost = 0;
		while (pq.size() > 1) {
			int small1 = pq.remove();
			int small2 = pq.remove();
			totCost += (small1 + small2);
			pq.add(small1 + small2);
		}
		return totCost;
	}

	public static void main(String[] args) {
		int[] files = {2,5,6,3,8,4 };
		//int[] files = { 6,5,4,3,1};
		System.out.println(getMergeCost(files));
	}
}