package com.naresh.concepts.collections;

import java.util.HashSet;
import java.util.Set;

public class HashCodeMethod_Name {
	private final String first, last;
	public HashCodeMethod_Name(String first , String last){
		this.first = first;
		this.last =last;
	}
	public static void main(String[] args) {
		Set<HashCodeMethod_Name> s = new HashSet<HashCodeMethod_Name>();
		s.add(new HashCodeMethod_Name("Naresh","Nalla"));
		System.out.println(s.contains(new HashCodeMethod_Name("Naresh","Nalla")));
	}
	public int hashCode(){
		return 63 * first.hashCode() + last.hashCode();
	}
	public boolean equals(Object o){
		if(!(o instanceof HashCodeMethod_Name))
			return false;
		HashCodeMethod_Name n = (HashCodeMethod_Name)o;
		return n.first.equals(first) && n.last.equals(last);
	}
	

}
