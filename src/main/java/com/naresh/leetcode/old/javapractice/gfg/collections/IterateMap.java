package com.naresh.leetcode.old.javapractice.gfg.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterateMap {
	public static void main(String[] args) {
		Map<String , String> project= new HashMap<String, String>();
		project.put("p1", "OptumRx");
		project.put("p2", "Guroo");
		project.put("p3", "Optumrx mobile");
		//1.Iterating over Map.entrySet() using For-Each loop
		for(Map.Entry<String, String> entry: project.entrySet()){
			System.out.println("Key= "+entry.getKey()+" , Value= "+entry.getValue());
		}
		
		//2.Iterating over keys or values using keySet() and values() methods
		for(String name : project.keySet()){
			System.out.println("\n");
			System.out.println("2.Key: "+name);
		}
		for (String value : project.values()) {
			System.out.print("2.Value:"+value);
		}
		//3.Iterating using iterators over Map.Entry<K, V>
		Iterator<Map.Entry<String, String>> itr = project.entrySet().iterator();
		System.out.println("\n");
		while(itr.hasNext()){
			Map.Entry<String, String> entry = itr.next();
			System.out.println("Key = " + entry.getKey() + 
                    ", Value = " + entry.getValue());
		}
		//4.Using forEach(action) method :
		System.out.println("\n");
		project.forEach((k,v) -> System.out.println("Key= "+k+", Value="+v));
		
		
		//5.Iterating over keys and searching for values (inefficient)
		System.out.println("\n 5");
		for( String name: project.keySet()){
			String pname = project.get(name);
			System.out.println("Key= "+name+" , Value= "+pname);
		}
		//6.streem
		System.out.println("\n 6");
		project.entrySet().stream().forEach(e -> System.out.println("Key= "+ e.getKey()+", Value="+e.getValue()));
		
/*		7.Using IterableMap of Apache Collections

		long i = 0;
		MapIterator<Integer, Integer> it = iterableMap.mapIterator();
		while (it.hasNext()) {
		    i += it.next() + it.getValue();
		}

		8.Using MutableMap of Eclipse (CS) collections

		final long[] i = {0};
		mutableMap.forEachKeyValue((key, value) -> {
		    i[0] += key + value;
		});
		
		map.entrySet().stream().[parallel().]mapToInt(e -> e.getKey() + e.getValue()).sum();
		
		*/
		
	}
}
