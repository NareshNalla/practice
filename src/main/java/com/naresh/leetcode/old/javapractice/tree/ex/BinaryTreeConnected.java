package com.naresh.leetcode.old.javapractice.tree.ex;

public class BinaryTreeConnected {
	Node root;
	
	void connect(Node p){
		p.nextRight = null;
		connectRecur(p);
	}
	void connectRecur(Node p){
		if(p == null){
			return;
		}
		if(p.left != null){
			p.left.nextRight = p.right;
		}
		
		if(p.right != null){
			p.right.nextRight = (p.nextRight != null) ? p.nextRight.left:null;
		}
		
		connectRecur(p.left);
		connectRecur(p.right);
		
	}
	
}
