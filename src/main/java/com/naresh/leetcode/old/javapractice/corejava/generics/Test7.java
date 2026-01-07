package com.naresh.leetcode.old.javapractice.corejava.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class B {

}

class C extends B {

}

public class Test7 {

	public static <E extends B> Queue<E> ring(List<E> list) {

		return null;

	}
    public static <E extends B> PriorityQueue<E> ringp(List<E> list) {

        return null;

    }

	public static void main(String[] args) {

		List<C> list1 = new ArrayList<C>();

		ArrayList<C> list2 = new ArrayList<C>();

		Queue<C> q1;

		PriorityQueue<C> q2;

		q1 = ring(list1); // line1

		q1 = ring(list2); // line2

        //q2 = ring(list1); // line3 // error ava: incompatible types: no instance(s) of type variable(s) E exist so that java.util.Queue<E> conforms to java.util.PriorityQueue<
		q2 = ringp(list1); // line3

		q2 = ringp(list2); // line4

	}

}