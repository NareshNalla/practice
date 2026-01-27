package com.naresh.dsa.basic.queue.heap.ex;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

// O(nlogn)  so bad. just for understanding
public class LargestSmalestSortedSet {
	public static void main(String[] args) {
		SortedSet set=new TreeSet<>();
		set.add(12);
		set.add(19);
		set.add(3);
		set.add(4);
		set.add(26);
		set.add(7);
		String a[]=new String[set.size()];

		int count=0;
		Iterator it=set.iterator();
		while(it.hasNext())
		{
			Object element = it.next();
			a[count]=element.toString();
			System.out.println(element.toString());
			count=count+1;

		} 
		System.out.println("smallest element is "+a[0]);
		System.out.println("second smallest element is "+a[1]);
	}

}
