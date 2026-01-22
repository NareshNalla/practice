package com.naresh.old.javapractice.javaconcepts.corejava.outputs.factset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SomeThingTest {
	@Test
	public void test_somthing(){
		List<Number> nums=new ArrayList<>();
		List<Integer> integers=Arrays.asList(1,2,3,4);
		List<Double> doubles=Arrays.asList(1.1,2.2,3.3,4.4);
		
//		addAll(nums,integers);
//		addAll(nums,doubles);
		
	}

	public static <T> void addAll(List<T> sink, List<T> source) {
		// TODO Auto-generated method stub
		sink.addAll(source);
		
	}

}

/*
 * public static <T> void addAll(List<Number> sink, List<Integer> source) {
 * sink.addAll(source);
 * 
 * }
 */

/*The method addAll(List<T>, Collection<T>) in the type SomeThingTest
 *  is not applicable for the arguments
 *   (List<Number>, List<Integer>)
 *   
 *   The method addAll(List<T>, Collection<T>) in the type SomeThingTest 
 *   is not applicable for the arguments (List<Number>, List<Double>)
 */
