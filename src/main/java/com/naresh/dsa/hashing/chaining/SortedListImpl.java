package com.naresh.dsa.hashing.chaining;

public class SortedListImpl {
	private Link first;
	public void SortedListIml(){
		first = null;
	}
	public void insert(Link theLink){
		int key = theLink.iData;
		Link previous = null;
		Link current = first;
		while(current != null && key> current.iData){
			previous = current;
			current = current.next;
		}if( previous == null){
			first = theLink;
		}else{
			previous.next = theLink;
			theLink.next = current;
		}
	}
	public void delete(int key){
		Link previous = null;
		Link current = first;
		while( current != null && key != current.iData){
			previous = current;
			current= current.next;
		}if(previous == null){
			first= first.next;
		}else
			previous.next = current.next;
	}
	public Link find(int key){
		Link current=first;
		while(current != null && current.iData <= key){
			if(current.iData == key)
				return current;
			current =current.next;
		}
		return null;
	}
	public void displayList(){
		System.out.println("List (first->last): ");
		Link current=first;
		while(current !=null){
			current.displayLink();
			current= current.next;
		}
		System.out.println("");
	}
	

}
