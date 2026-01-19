package com.naresh.old.javapractice.tree.ex;

public class BinaryTreeConnectTest {
	public static void main(String[] args) {
		BinaryTreeConnected btc = new BinaryTreeConnected();
		btc.root = new Node("A");
		btc.root.left = new Node("B");
		btc.root.right = new Node("C");
		btc.root.left.left = new Node("D");
		btc.root.left.right = new Node("E");
		
		
		btc.connect(btc.root);
		 System.out.println("Following are populated nextRight pointers in the tree (-1 is printed if there is no neextRight)");
		 String a = btc.root.nextRight != null ? btc.root.nextRight.data : "NULL";
		 System.out.println("nextRight of "+ btc.root.data +" is "+a);
		 
		 String b = btc.root.left.nextRight != null ? btc.root.left.nextRight.data : "NULL";
		 System.out.println("nextRight of "+ btc.root.left.data +" is "+b);
		 
		 String c = btc.root.right.nextRight != null ? btc.root.right.nextRight.data :"NULL";
		 System.out.println("nextRight of "+ btc.root.right.data +" is "+c);
		 
		 String d = btc.root.left.left.nextRight != null ? btc.root.left.left.nextRight.data : "NULL";
		 System.out.println("nextRight of "+ btc.root.left.left.data +" is "+d);
		 
		 
		
	}

 
 
}

