package com.naresh.old.javapractice.tree;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		
		bst.add(bst.root, bst.nodeCreate(10));
		bst.add(bst.root, bst.nodeCreate(12));
		bst.add(bst.root, bst.nodeCreate(11));
		bst.add(bst.root, bst.nodeCreate(13));
		bst.add(bst.root, bst.nodeCreate(6));
		
		bst.search(10, bst.root);
	}
}
