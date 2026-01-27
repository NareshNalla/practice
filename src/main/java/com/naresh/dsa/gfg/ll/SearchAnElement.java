package com.naresh.dsa.gfg.ll;

public class SearchAnElement {
	static Node head;
		public static void seachNode(int i){
			Node n =head;
			int count =1;
			while(n != null){
				if(n.data == i){
					System.out.println("Is found:"+count);
					return;
				}
				count = count+1;
				n = n.next;
			}
			System.out.println("Not Found");
		}
		static int count = 1;
		public static boolean searchRecur(Node head,int x){
			Node n = head;
			
			if(n.data == x){
				System.out.println("fount :"+count);
				return true;
			}
			count= count+1;
			return searchRecur(n.next,x);
		}
		public static void insert(int i){
			Node newNode = new Node(i);
			newNode.next = head;
			head = newNode;
			
			
		}
		public static void main(String[] args) {
			/*SearchAnElement ll = new SearchAnElement();
			ll.head = new Node(1);
			Node second = new Node(2);
			Node third = new Node(3);
			
			ll.head.next = second;
			second.next = third;*/
			insert(5);
			insert(4);
			insert(2);
			insert(7);
			printlist();
			//seachNode(2);
			Node n = head;
			Boolean b = false;
			b = searchRecur(head,4);
			if(b == true){
				System.out.println("found");
			}else{
				System.out.println("Not found");
			}
			
	}
		private static void printlist() {
		Node n = head;
		while(n != null){
			System.out.println(n.data);
			n= n.next;
		}
}
}
class Node{
	
	 Node next;
	int data;
	Node(int data){
		this.next = null;
		this.data = data;
	}
}