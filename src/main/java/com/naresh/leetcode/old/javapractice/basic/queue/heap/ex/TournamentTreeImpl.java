package com.naresh.leetcode.old.javapractice.basic.queue.heap.ex;

import java.util.LinkedList;
/*the overall time complexity is n + logn. Auxiliary space needed is O(2n), as the number of leaf nodes will be approximately equal to the number of internal nodes.*/


public class TournamentTreeImpl {
	public int findSecondMin(int[] arr){
		int n = arr.length;
		LinkedList<Tnode> list = new LinkedList<>();
		for(int i=0;i<n; i+=2){
			Tnode t1= new Tnode(i);
			Tnode t2= null;
			if(i +1 < n){
				t2 = new Tnode(i +1);
				Tnode root = (arr[i] < arr[i +1]? new Tnode(i) : new Tnode(i + 1));
				root.left = t1;
				root.right = t2;
				list.add(root);
			}else
				list.add(t1);
		}
		while(list.size() !=1){
			Tnode t1 = list.pollLast();
			Tnode t2 = list.pollLast();
			Tnode root = (arr[t1.idx] < arr[t2.idx]) ? new Tnode(t2.idx) : new Tnode(t1.idx);
			root.left = t1;
			root.right = t2;
			list.add(root);
			 //list.getFirst(); first minimum element
		}
			Result result = new Result();
			fetchSecondSmallest(list.getFirst() , arr , result);
			return arr[result.value];
	}

	private void fetchSecondSmallest(Tnode node, int[] arr, Result result) {
		if(node == null || (node.left == null && node.right == null))
			return;
		/*check with side != root's idx and less than result and move to side with indx == roots idx.
		 * 
		 */
		if(result.value > arr[node.left.idx] && node.idx != node.left.idx){
			result.value = node.left.idx;
			fetchSecondSmallest(node.right, arr, result);
		}else if(result.value > arr[node.right.idx] && node.idx != node.right.idx){
			result.value = node.right.idx;
			fetchSecondSmallest(node.left, arr, result);
		}
	}
	public static void main(String[] args) {
		int arr[] = { 61, 6, 100, 9, 10, 12, 17};
		TournamentTreeImpl prob = new TournamentTreeImpl();
		System.out.println(prob.findSecondMin(arr));
	}

}
class Tnode{
	int idx;
	Tnode left;
	Tnode right;
	public Tnode(int val){
		this.idx = val;
		left = null;
		right = null;
	}
}
class Result {
	int value = Integer.MAX_VALUE;
}
/*
In general with M sorted lists of size L1, L2 � Lm requires time complexity of O((L1 + L2 + � + Lm) * logM) to merge all the arrays, and O(m*logM) time to find median, where m is median position.*/