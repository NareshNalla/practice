package com.naresh.dsa.basic.queue.heap.ex.merge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
//Not working for unsorted and its giving duplicates.
/*Time Complexity: O((n+m+..)log(k)) => O(N)!
Space Complexity : O(k) = constant!
(where n,m.. are the no. of elements in the arrays; total * log(k)= N)
(where k is the number of arrays)*/
public class MergeKSortedArrays {
	public static void main (String[] args) {
		//code
		int[] arr1 = { 1, 3, 9, 10 };
		int[] arr2 = { 2, 6, 12, 15 };
		int[] arr3 = { 7, 9, 13, 17 };
		ArrayList<int[]> arrr = new ArrayList<>();
		arrr.add(arr1);
		arrr.add(arr2);
		arrr.add(arr3);
		displayArr(mergeSortedArrays(arrr));
	}
	public static void displayArr(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		System.out.println(list);
	}
	public static class indexDataPair implements Comparable<indexDataPair> {
		int arrayNo;
		Integer data;

		public indexDataPair(Integer data, int arrayNo) {
			this.arrayNo = arrayNo;
			this.data = data;
		}

		@Override
		public int compareTo(indexDataPair o) {
			return this.data.compareTo(o.data);
		}

		public String toString() {
			return "(" + this.arrayNo + "," + this.data + ")";
		}
	}
	
	public static int[] mergeSortedArrays(ArrayList<int[]> arrr) {
		int size = 0;
		for (int i = 0; i < arrr.size(); i++) {
			if(arrr.get(i).length>0) {
				size += arrr.get(i).length;
			}else {
				arrr.remove(i);
			}
		}
		if (size == 0) {
			return null;
		}
		int[] retVal = new int[size];
		int k = 0;
		int[] indices = new int[arrr.size()];
		PriorityQueue<indexDataPair> queue = new PriorityQueue<>(new Comparator<indexDataPair>() {
			@Override
			public int compare(indexDataPair o1, indexDataPair o2) {
				return o1.compareTo(o2);
			}
		});
		for (int i = 0; i < arrr.size(); i++) {
			queue.add(new indexDataPair(arrr.get(i)[0], i));
		}
		int i = 0;
		while (!queue.isEmpty()) {
			indexDataPair pair = queue.remove();
			indices[pair.arrayNo]++;
			i = pair.arrayNo;
			retVal[k++] = pair.data;
			
			if (!(indices[i] == arrr.get(i).length)) {
				queue.add(new indexDataPair(arrr.get(i)[indices[i]], i));
			}
			i = (i + 1) % arrr.size();
		}

		return retVal;
	}

}
