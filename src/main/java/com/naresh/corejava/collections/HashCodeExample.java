package com.naresh.corejava.collections;

import java.util.HashSet;
import java.util.Set;

public class HashCodeExample {
	private final String first, last;
	public HashCodeExample(String first , String last){
		this.first = first;
		this.last =last;
	}
	public static void main(String[] args) {
		Set<HashCodeExample> s = new HashSet<HashCodeExample>();
		s.add(new HashCodeExample("Naresh","Nalla"));
		System.out.println(s.contains(new HashCodeExample("Naresh","Nalla")));
	}
	public int hashCode(){
		return 63 * first.hashCode() + last.hashCode();
	}
	public boolean equals(Object o){
		if(!(o instanceof HashCodeExample))
			return false;
		HashCodeExample n = (HashCodeExample)o;
		return n.first.equals(first) && n.last.equals(last);
	}
	

}
