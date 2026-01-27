package com.naresh.concepts.collections;
/* oracle interview qustion on 12/20*/
import java.util.ArrayList;

public class ArrayList1 {
	public static void main(String[] args) {
		ArrayList l = new ArrayList();
		l.add(0,1);
        l.add(0,1);
		l.set(1,9);
		l.set(1,3);
        System.out.println(l);
		System.out.println(l.get(0));
		System.out.println(l.get(1));
		
	}

}

