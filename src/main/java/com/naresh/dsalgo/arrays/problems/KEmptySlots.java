package com.naresh.dsalgo.arrays.problems;

import java.util.*;

public class KEmptySlots {

    /*
     * public static int kemptySlots1(int[] in, int k) { BitSet bset = new
     * BitSet(in.length); for (int i = 0; i < in.length; ++i) { int pos = in[i]; for
     * (int current = pos; current >= 0 && current < pos - k; --current) { if
     * (bset.get(current) == true && pos - current - 1 == k) return i + 1; } for
     * (int current = pos; current < in.length && current < pos + k; ++current) { if
     * (bset.get(current) == true && current - pos - 1 == k) return i + 1; }
     * bset.set(pos); } return -1;
     * 
     * }
     */

    public static int kemptySlots2(int[] in, int k) {
	TreeSet<Integer> tset = new TreeSet<Integer>();
	for (int i = 0; i < in.length; ++i) {
	    int pos = in[i];
	    Integer floor = tset.floor(pos);
	    if (floor != null && pos - floor - 1 == k)
		return i + 1;
	    Integer ceil = tset.ceiling(pos);
	    if (ceil != null && ceil - pos - 1 == k)
		return i + 1;
	    tset.add(pos);
	}
	return -1;
    }

    public static void main(String[] args) {
	int n = 6;//Integer.parseInt(args[0]);
	int k = 2;//Integer.parseInt(args[1]);
	List<Integer> list = new ArrayList<Integer>();
	for(int i = 1; i <= n; ++i)
		list.add(i);
	Collections.shuffle(list);
	int[] in = new int[n+1];
	for(int i = 1; i <= n; ++i)
		in[i] = list.remove(0);
	 int arr[] = { 2, 6 };
	System.out.println(Arrays.toString(in));
	System.out.println(kemptySlots2(arr, k));

    }

    public static void minTime(int arr[], int N, int K) {

// Stores visited slots
	Queue<Integer> q = new LinkedList<>();

// Checks if a slot is visited or not
	boolean vis[] = new boolean[N + 1];
	int time = 0;

// Insert all filled slots
	for (int i = 0; i < K; i++) {

	    q.add(arr[i]);
	    vis[arr[i]] = true;
	}

// Iterate until queue is
// not empty
	while (q.size() > 0) {

// Iterate through all slots
// in the queue
	    for (int i = 0; i < q.size(); i++) {

		// Front index
		int curr = q.poll();

		// If previous slot is
		// present and not visited
		if (curr - 1 >= 1 && !vis[curr - 1]) {
		    vis[curr - 1] = true;
		    q.add(curr - 1);
		}

		// If next slot is present
		// and not visited
		if (curr + 1 <= N && !vis[curr + 1]) {

		    vis[curr + 1] = true;
		    q.add(curr + 1);
		}
	    }

// Increment the time
// at each level
	    time++;
	}

// Print the answer
	System.out.println(time - 1);
    }

}