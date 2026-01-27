package com.naresh.dsa.hash.ex.separateChainingHash;

public class Link {
	public int iData;
	public Link next;
	public Link(int it){
		iData = it;
	}
	public void displayLink(){
		System.out.print(iData + " ");
	}

}
