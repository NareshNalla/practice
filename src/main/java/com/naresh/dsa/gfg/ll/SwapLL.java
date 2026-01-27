package com.naresh.dsa.gfg.ll;

public class SwapLL {
	static Node1 head;
	
public static void main(String[] args) {
	push(11);
	push(21);
	push(31);
	push(40);
	print();
	System.out.println("..............");
	//swaptwo(11,31);
	swaptwo(11,40);
	
	print();
}
private static void swaptwo(int i, int j) {
	if(i == j) return;
	Node1 currX = head;
	Node1 prevX = null;
	
	while(currX != null && currX.data != i){
		prevX = currX;
		currX = currX.next;
	}
	
	Node1 currY = head;
	Node1 prevy = null;
	while(currY != null && currY.data != j){
		prevy = currY;
		currY = currY.next;
	}
	
	if(currX == null || currY == null)
		return;
	
	if(prevX != null){
		prevX.next = currY;
	}else{
		head =currY;
	}
	
	if(prevy != null){
		prevy.next = currX;
	}else{
		head = currX;
	}
	
	Node1 temp = currX.next;
	currX.next = currY.next;
	currY.next = temp;	
	
}
private static void print() {

	Node1 n = head;
	while(n != null){
		System.out.println(n.data);
		n = n.next;
	}
}
private static void push(int i) {
	Node1 newNode = new Node1(i);
	newNode.next = head;
	head = newNode;
}

}
class Node1{
	Node1 next;
	int data;
	Node1(int data){
		this.next = null;
		this.data = data;
	}
}
