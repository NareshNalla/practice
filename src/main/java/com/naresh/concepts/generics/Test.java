package com.naresh.concepts.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* What is the result of compiling and running the following program?*/
public class Test {
	public static void main(String[] args) {

        List<String> list1 = new ArrayList<String>();//line 1

        List<Object> list2 = Collections.singletonList(list1);//line 2

        list2.add(new Integer(12));//line 3

        System.out.println(list2.size());//line 4

	}

}
